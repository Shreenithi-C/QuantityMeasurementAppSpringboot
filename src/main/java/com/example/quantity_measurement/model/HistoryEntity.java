package com.example.quantity_measurement.model;

import jakarta.persistence.*;

@Entity
@Table(name = "history")
public class HistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String operation;

    @Column(nullable = false)
    private String expression;

    @Column(nullable = false)
    private String result;

    public HistoryEntity() {}

    public HistoryEntity(String operation, String expression, String result) {
        this.operation = operation;
        this.expression = expression;
        this.result = result;
    }

    public Long getId() { return id; }

    public String getOperation() { return operation; }
    public void setOperation(String operation) { this.operation = operation; }

    public String getExpression() { return expression; }
    public void setExpression(String expression) { this.expression = expression; }

    public String getResult() { return result; }
    public void setResult(String result) { this.result = result; }
}
