package com.example.quantity_measurement.controller;

import com.example.quantity_measurement.dto.QuantityInputDTO;
import com.example.quantity_measurement.dto.QuantityMeasurementDTO;
import com.example.quantity_measurement.model.HistoryEntity;
import com.example.quantity_measurement.model.UnitEntity;
import com.example.quantity_measurement.service.QuantityMeasurementService;
import com.example.quantity_measurement.repository.HistoryRepository;
import com.example.quantity_measurement.repository.UnitRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quantity")
public class QuantityMeasurementController {

    @Autowired
    private QuantityMeasurementService service;

    @Autowired
    private HistoryRepository historyRepository;

    @Autowired
    private UnitRepository unitRepository;  // ✅ add this

    @PostMapping("/convert")
    public QuantityMeasurementDTO convert(@RequestBody QuantityInputDTO input) {
        return service.convert(input);
    }

    @PostMapping("/compare")
    public QuantityMeasurementDTO compare(@RequestBody QuantityInputDTO input) {
        return service.compare(input);
    }

    @PostMapping("/arithmetic")
    public QuantityMeasurementDTO arithmetic(@RequestBody QuantityInputDTO input) {
        return service.arithmetic(input);
    }

    @GetMapping("/history")
    public List<HistoryEntity> getHistory() {
        return historyRepository.findAll();
    }

    @GetMapping("/units")
    public List<UnitEntity> getAllUnits() {
        return unitRepository.findAll();  
    }

    @DeleteMapping("/history/clear")
    public ResponseEntity<Void> clearHistory() {
        historyRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
