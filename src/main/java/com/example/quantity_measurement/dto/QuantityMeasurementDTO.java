package com.example.quantity_measurement.dto;

public class QuantityMeasurementDTO {

    private String operation;   // e.g. "CONVERT", "COMPARE", "ADD"
    private String expression;  // e.g. "2 METER -> KILOMETER"
    private String result;      // e.g. "0.002 KILOMETER" or "GREATER"

    public QuantityMeasurementDTO() {}

    public QuantityMeasurementDTO(String operation, String expression, String result) {
        this.operation = operation;
        this.expression = expression;
        this.result = result;
    }

    public String getOperation() { return operation; }
    public void setOperation(String operation) { this.operation = operation; }

    public String getExpression() { return expression; }
    public void setExpression(String expression) { this.expression = expression; }

    public String getResult() { return result; }
    public void setResult(String result) { this.result = result; }
}
