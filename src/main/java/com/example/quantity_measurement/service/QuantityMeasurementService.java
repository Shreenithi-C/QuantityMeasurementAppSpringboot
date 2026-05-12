package com.example.quantity_measurement.service;

import com.example.quantity_measurement.dto.QuantityInputDTO;
import com.example.quantity_measurement.dto.QuantityMeasurementDTO;

public interface QuantityMeasurementService {

    QuantityMeasurementDTO convert(QuantityInputDTO input);

    QuantityMeasurementDTO compare(QuantityInputDTO input);

    QuantityMeasurementDTO arithmetic(QuantityInputDTO input);
}
