package com.example.quantity_measurement.service;

import com.example.quantity_measurement.dto.QuantityInputDTO;
import com.example.quantity_measurement.dto.QuantityMeasurementDTO;
import com.example.quantity_measurement.model.HistoryEntity;
import com.example.quantity_measurement.model.UnitEntity;
import com.example.quantity_measurement.model.enums.ComparisonType;
import com.example.quantity_measurement.model.enums.MeasurementType;
import com.example.quantity_measurement.model.enums.OperationType;
import com.example.quantity_measurement.repository.HistoryRepository;
import com.example.quantity_measurement.repository.UnitRepository;
import com.example.quantity_measurement.exception.InvalidConversionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuantityMeasurementServiceImpl implements QuantityMeasurementService {

    @Autowired
    private HistoryRepository historyRepository;

    @Autowired
    private UnitRepository unitRepository;

    @Override
    public QuantityMeasurementDTO convert(QuantityInputDTO input) {
        System.out.println("CONVERT input: value1=" + input.getValue1() +
                           ", fromUnit=" + input.getFromUnit() +
                           ", toUnit=" + input.getToUnit());

        double result = convertValue(input.getValue1(), input.getFromUnit(), input.getToUnit());

        String expr = input.getValue1() + " " + input.getFromUnit() + " -> " + input.getToUnit();
        String res = result + " " + input.getToUnit();

        historyRepository.save(new HistoryEntity("CONVERT", expr, res));
        return new QuantityMeasurementDTO("CONVERT", expr, res);
    }

    @Override
    public QuantityMeasurementDTO compare(QuantityInputDTO input) {
        System.out.println("COMPARE input: value1=" + input.getValue1() +
                           ", unit1=" + input.getUnit1() +
                           ", value2=" + input.getValue2() +
                           ", unit2=" + input.getUnit2());

        double v1 = input.getValue1(); // already in unit1
        double v2 = convertValue(input.getValue2(), input.getUnit2(), input.getUnit1());

        ComparisonType result;
        if (v1 > v2) result = ComparisonType.GREATER;
        else if (v1 < v2) result = ComparisonType.LESS;
        else result = ComparisonType.EQUAL;

        String expr = input.getValue1() + " " + input.getUnit1() + " vs " +
                      input.getValue2() + " " + input.getUnit2();
        String res = result.name();

        historyRepository.save(new HistoryEntity("COMPARE", expr, res));
        return new QuantityMeasurementDTO("COMPARE", expr, res);
    }

    @Override
    public QuantityMeasurementDTO arithmetic(QuantityInputDTO input) {
        double v1 = input.getValue1();
        double v2 = convertValue(input.getValue2(), input.getUnit2(), input.getUnit1());

        double result;
        switch (input.getOperation()) {
            case ADD: result = v1 + v2; break;
            case SUBTRACT: result = v1 - v2; break;
            case MULTIPLY: result = v1 * v2; break;
            case DIVIDE:
                if (v2 == 0) throw new RuntimeException("Divide by zero");
                result = v1 / v2;
                break;
            default: throw new RuntimeException("Invalid operation");
        }

        String expr = v1 + " " + input.getUnit1() + " " +
                      input.getOperation() + " " +
                      input.getValue2() + " " + input.getUnit2();
        String res = result + " " + input.getUnit1();

        historyRepository.save(new HistoryEntity("ARITHMETIC", expr, res));
        return new QuantityMeasurementDTO(input.getOperation().name(), expr, res);
    }

    private double convertValue(double value, String fromUnitName, String toUnitName) {
        // Debug logging
        System.out.println("convertValue called: value=" + value +
                           ", fromUnit=" + fromUnitName +
                           ", toUnit=" + toUnitName);

        UnitEntity from = unitRepository.findByName(fromUnitName)
                .orElseThrow(() -> new InvalidConversionException("Invalid from unit: " + fromUnitName));
        UnitEntity to = unitRepository.findByName(toUnitName)
                .orElseThrow(() -> new InvalidConversionException("Invalid to unit: " + toUnitName));

        // Check type compatibility
        if (from.getType() != to.getType()) {
            throw new InvalidConversionException("Invalid unit conversion between " + fromUnitName + " and " + toUnitName);
        }

        // Special handling for temperature conversions
        if (from.getType() == MeasurementType.TEMPERATURE) {
            String fromName = from.getName();
            String toName = to.getName();

            if (fromName.equals("CELSIUS") && toName.equals("FAHRENHEIT")) return (value * 9 / 5) + 32;
            if (fromName.equals("FAHRENHEIT") && toName.equals("CELSIUS")) return (value - 32) * 5 / 9;
            if (fromName.equals("CELSIUS") && toName.equals("KELVIN")) return value + 273.15;
            if (fromName.equals("KELVIN") && toName.equals("CELSIUS")) return value - 273.15;
            if (fromName.equals("KELVIN") && toName.equals("FAHRENHEIT")) return (value - 273.15) * 9/5 + 32;
            if (fromName.equals("FAHRENHEIT") && toName.equals("KELVIN")) return (value - 32) * 5/9 + 273.15;
            return value; // same unit
        }

        // General conversion using base values
        double base = value * from.getBaseValue();
        return base / to.getBaseValue();
    }

}
