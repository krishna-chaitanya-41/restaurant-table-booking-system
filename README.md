# Restaurant Table Booking System

Spring Boot backend application for restaurant table reservations with JWT authentication and REST APIs.

## Features

* User Authentication & Authorization using JWT
* Role-Based Access Control with Spring Security
* Restaurant Management
* Restaurant Table Management
* Table Booking System
* Real-Time Table Availability Checking
* Duplicate Booking Prevention
* Global Exception Handling
* Input Validation
* Layered Architecture (Controller → Service → Repository)

## Tech Stack

* Java
* Spring Boot
* Spring Security
* JWT Authentication
* Spring Data JPA
* PostgreSQL
* Maven
* Lombok
* REST APIs

## Project Structure

```bash id="m7l2xa"
src/main/java/com/example/RestaurantTableBooking
│
├── auth
├── config
├── controller
├── dto
├── entity
├── exception
├── repository
├── security
├── service
└── RestaurantTableBookingApplication.java
```

## API Functionalities

* User Registration & Login
* Add & Manage Restaurants
* Add & Manage Restaurant Tables
* Book Tables
* View Booking Details
* Prevent Duplicate Reservations
* Handle Invalid Requests & Exceptions

## Setup Instructions

1. Clone the repository

```bash id="u2v7nm"
git clone <repository-url>
```

2. Navigate to the project directory

```bash id="b3xt1r"
cd restaurant-table-booking-system
```

3. Configure PostgreSQL database credentials in `application.properties`

4. Run the application

```bash id="t0f5jlwm"
./mvnw spring-boot:run
```

## Testing

API endpoints can be tested using Postman.

## Author

Kalikota Krishna Chaitanya
