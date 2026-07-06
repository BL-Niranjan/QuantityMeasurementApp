📏 Quantity Measurement App
Java Spring Boot Spring Data JPA Hibernate H2 MySQL JUnit5 Mockito License

A Spring Boot REST API for performing Quantity Measurement, Unit Conversion, Comparison, and Arithmetic Operations using clean architecture and object-oriented design principles.

📖 Overview
The Quantity Measurement App is a RESTful web application built using Spring Boot that allows users to compare, convert, and perform arithmetic operations on different measurement units.

The application supports multiple measurement types such as:

📏 Length
⚖ Weight
🌡 Temperature
🧪 Volume
It also stores operation history in a database and exposes REST APIs for performing calculations and retrieving historical records.

🚀 Features
✅ Compare Quantities
✅ Add Quantities
✅ Unit Conversion
✅ Operation History
✅ Operation Count
✅ H2 Database Support
✅ MySQL Support
✅ REST APIs
✅ Spring Data JPA
✅ Hibernate ORM
✅ Global Exception Handling
✅ DTO Based Architecture
✅ Layered Architecture
✅ Swagger/OpenAPI Documentation
✅ Unit Testing
✅ Mockito Testing
✅ MockMvc Controller Testing
🏗 Project Architecture
                   Client

                      │
                      ▼

          QuantityMeasurementController

                      │
                      ▼

         QuantityMeasurementService

                      │
                      ▼

      QuantityMeasurementRepository

                      │
                      ▼

            H2 / MySQL Database
📂 Project Structure
QuantityMeasurementApp
│
├── src
│
├── controller
│     └── QuantityMeasurementController.java
│
├── service
│     ├── IQuantityMeasurementService.java
│     └── QuantityMeasurementService.java
│
├── repository
│     └── QuantityMeasurementRepository.java
│
├── dto
│     ├── QuantityDTO.java
│     ├── QuantityInputDTO.java
│     └── QuantityMeasurementDTO.java
│
├── entity
│     └── QuantityMeasurement.java
│
├── enums
│     ├── LengthUnit.java
│     ├── WeightUnit.java
│     ├── VolumeUnit.java
│     └── TemperatureUnit.java
│
├── exception
│     ├── GlobalExceptionHandler.java
│     └── QuantityMeasurementException.java
│
├── util
│     └── UnitConverter.java
│
├── config
│     └── SwaggerConfig.java
│
├── resources
│     ├── application.properties
│     └── data.sql
│
└── QuantityMeasurementApplication.java
📐 Supported Measurement Types
Length
Feet
Inch
Yard
Centimeter
Meter
Kilometer
Weight
Gram
Kilogram
Ton
Volume
Milliliter
Liter
Gallon
Temperature
Celsius
Fahrenheit
Kelvin

📄 License
This project is licensed under the MIT License.

Developed for learning, practice, and educational purposes.
