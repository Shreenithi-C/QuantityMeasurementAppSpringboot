package com.example.quantity_measurement.model;

public class QuantityMeasurement {

    private double value;
    private String unit;

    // Default constructor (needed for frameworks like Jackson)
    public QuantityMeasurement() {
    }

    // Parameterized constructor
    public QuantityMeasurement(double value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    // Getters and setters
    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    // Optional: toString for debugging/logging
    @Override
    public String toString() {
        return value + " " + unit;
    }
}
