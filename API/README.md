# Simple Task Manager – Backend

## Overview
This is the backend application for the Simple Task Manager. It provides REST APIs to create and retrieve tasks.

## Technologies Used
- Java 21
- Spring Boot 3
- Maven
- Spring Data JPA / Hibernate
- H2 In-Memory Database
- Jakarta Validation
- JUnit

## Features
- Create a new task.
- Retrieve all existing tasks.
- Automatically generate a unique ID for each task.
- Validate task title and input fields.
- Handle application errors.
- Use separate Controller, Service, Repository, Entity and DTO layers.

## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/tasks` | Create a new task |
| GET | `/api/tasks` | Retrieve all tasks |

### Sample Request

```json
{
  "title": "Complete assignment",
  "description": "Finish the task manager application"
}
```

## Database
The application uses an H2 in-memory database. Hibernate manages the database tables using JPA.

Note: Since this is an in-memory database, the data is cleared when the backend application restarts.

## Project Structure

- `controller` – Handles incoming REST API requests.
- `service` – Contains business logic.
- `repository` – Handles database operations.
- `entity` – Defines the database entity.
- `dto` – Handles request and response objects.
- `exception` – Handles application exceptions.

## How to Run

1. Open the `API` project in IntelliJ IDEA.
2. Make sure Java 21 is configured.
3. Run the Spring Boot application.
4. The backend starts at:

   `http://localhost:8080`

## Testing
The REST APIs were tested using Postman. JUnit tests are included to verify backend functionality.
Added CORS annotation in controller class to allow the 'localhost:4200' origin.