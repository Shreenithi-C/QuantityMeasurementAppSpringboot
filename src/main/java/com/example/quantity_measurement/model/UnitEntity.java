package com.example.quantity_measurement.model;

import com.example.quantity_measurement.model.enums.MeasurementType;
import jakarta.persistence.*;

@Entity
@Table(name = "units")
public class UnitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MeasurementType type;

    @Column(nullable = false)
    private double baseValue;

    public UnitEntity() {}

    public UnitEntity(String name, MeasurementType type, double baseValue) {
        this.name = name;
        this.type = type;
        this.baseValue = baseValue;
    }

    public Long getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public MeasurementType getType() { return type; }
    public void setType(MeasurementType type) { this.type = type; }

    public double getBaseValue() { return baseValue; }
    public void setBaseValue(double baseValue) { this.baseValue = baseValue; }
}
