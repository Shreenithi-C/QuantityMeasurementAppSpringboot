# Quantity Measurement App

##  Overview

This is a Spring Boot REST API that performs quantity measurement operations such as:

* Unit Conversion
* Comparison
* Arithmetic Operations
* History Tracking

Supports:

* Length
* Weight
* Volume
* Temperature

---

##  Tech Stack

* Java 17
* Spring Boot
* Spring Data JPA
* H2 Database
* Swagger (API Testing)
* Mockito (Unit Testing)

---

##  Features

✔ Convert units (e.g., KM → M, KG → G)
✔ Compare values (e.g., 1 km vs 500 m)
✔ Arithmetic operations (+, -, *, /)
✔ Store history of operations
✔ Global Exception Handling
✔ Logging with SLF4J
✔ Swagger UI for testing

---

##  API Endpoints

### 🔹 POST APIs

* `/api/quantity/convert`
* `/api/quantity/compare`
* `/api/quantity/arithmetic`
* `/api/quantity/units`
* `/api/quantity/conversions`

### 🔹 GET APIs

* `/api/quantity/units`
* `/api/quantity/conversions`
* `/api/quantity/history`

---

##  Sample Request (Convert)

```json
{
  "value1": 1,
  "fromUnit": "KILOMETER",
  "toUnit": "METER"
}
```

---

##  Sample Response

```json
{
  "operation": "CONVERT",
  "result": 1000.0,
  "unit": "METER"
}
```

---

##  Database

Uses H2 in-memory database.

Tables:

* Units
* Conversions
* History

---

##  Swagger UI

Access API documentation at:

```
http://localhost:8080/swagger-ui/index.html
```

---

##  Exception Handling

Custom exception handling implemented using:

* `@RestControllerAdvice`
* Custom exceptions

---

##  Logging

Logging implemented using SLF4J:

* Controller → Request logs
* Service → Logic & result logs

---

##  Testing

Unit testing implemented using:

* JUnit 5
* Mockito

---

##  Project Structure

```
controller/
service/
repository/
model/
dto/
exception/
```

---

