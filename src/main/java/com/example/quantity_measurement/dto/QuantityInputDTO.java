package com.example.quantity_measurement.dto;

import com.example.quantity_measurement.model.enums.OperationType;
import jakarta.validation.constraints.NotNull;

public class QuantityInputDTO {

    @NotNull
    private Double value1;
    private String unit1;

    private Double value2;
    private String unit2;

    private String fromUnit;
    private String toUnit;

    private OperationType operation;

    public Double getValue1() { return value1; }
    public void setValue1(Double value1) { this.value1 = value1; }

    public String getUnit1() { return unit1; }
    public void setUnit1(String unit1) { this.unit1 = unit1; }

    public Double getValue2() { return value2; }
    public void setValue2(Double value2) { this.value2 = value2; }

    public String getUnit2() { return unit2; }
    public void setUnit2(String unit2) { this.unit2 = unit2; }

    public String getFromUnit() { return fromUnit; }
    public void setFromUnit(String fromUnit) { this.fromUnit = fromUnit; }

    public String getToUnit() { return toUnit; }
    public void setToUnit(String toUnit) { this.toUnit = toUnit; }

    public OperationType getOperation() { return operation; }
    public void setOperation(OperationType operation) { this.operation = operation; }
}
