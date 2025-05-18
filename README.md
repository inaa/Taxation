# Taxation Service
A Java Spring Boot application for calculating various types of taxes, including general income tax and winnings tax with different calculation strategies.

## Overview
The Taxation Service provides RESTful API endpoints for tax calculation with the following features:
- General income tax calculation by rate (percentage-based)
- General income tax calculation by amount (fixed-amount based)
- Winnings tax calculation by rate 
- Winnings tax calculation by amount 

## API Endpoints
### General Tax Calculation
``` 
POST /general
```
Calculates general income tax based on the provided income and applicable rate, using either a percentage rate or fixed amount.
### Winnings Tax Calculation
``` 
POST /winnings
```
Calculates tax on gambling winnings using either a percentage rate or fixed amount.
**Parameters:**
- `rate` (Optional): Tax rate as a percentage - - **IMPORTANT: Must be entered as decimal (0.1) not percentage (10)**
- `amount` (Optional): Fixed tax amount

**Note:** Either `rate` or `amount` must be provided, but not both.

## Postman Collection
A Postman collection with example requests is included in the project resources. You can find it at:
``` 
src/main/resources/postman/Taxation.postman_collection.json
```
Import this collection into Postman to quickly test the API endpoints with pre-configured example requests.

## Building and Running
### Prerequisites
- Java 21 or higher
- Maven

### Building the Project
``` bash
mvn clean install
```
### Running the Application
``` bash
mvn spring-boot:run
```
The application will start on port 8080 by default.
## Testing
Run the tests using Maven:
``` bash
mvn test
```

