# Simple Task Manager

## 1. Overview

Simple Task Manager is a web application developed using Angular and Spring Boot.

It allows users to create tasks with a title and optional description and view all existing tasks.

The application follows a frontend-backend architecture, where Angular communicates with Spring Boot REST APIs to store and retrieve task information.

## 2. Technologies Used

**Frontend**
- Angular
- TypeScript
- HTML
- CSS
- Angular Reactive Forms
- Angular HttpClient

**Backend**
- Java 21
- Spring Boot 3
- Maven
- Spring Data JPA / Hibernate
- H2 In-Memory Database
- Jakarta Validation
- JUnit

## 3. Application Features

- Create a new task with a mandatory title and optional description.
- Automatically generate a unique task ID.
- Display all existing tasks when the application loads.
- Update the task list immediately after creating a new task without refreshing the page.
- Validate user inputs.
- Display success and error messages.
- Handle backend exceptions.

## 4. Project Structure

```text
task-manager-app/
│
├── API/
│   ├── src/
│   └── pom.xml
│
├── UI/
│   ├── src/
│   ├── package.json
│   └── angular.json
│
├── screenshots/
│
└── README.md
```

## 5. Backend Details

The backend is developed using Spring Boot and provides REST APIs to create and retrieve tasks.

### API Endpoints

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

### Backend Layers

- **Controller:** Handles incoming REST API requests.
- **Service:** Contains business logic.
- **Repository:** Handles database operations.
- **Entity:** Defines the database entity.
- **DTO:** Handles request and response objects.
- **Exception:** Handles application exceptions.

### Database

The application uses an H2 in-memory database with Spring Data JPA and Hibernate.

Note: Since this is an in-memory database, the data is cleared when the backend application restarts.

## 6. Frontend Details

The frontend is developed using Angular with a single-page application approach.

### Main Components

- **Task Page:** Provides the task creation form and displays the task list.
- **Task Service:** Communicates with backend REST APIs using HttpClient.
- **Task Model:** Defines the task data structure.

### Form Validation

- Task title is mandatory.
- Description is optional.
- Title and description have maximum length validations.
- The Add Task button remains disabled until a valid title is entered.

### UI Updates

Angular Signals are used to manage the task list.

- Existing tasks are loaded automatically when the page opens.
- Newly created tasks are added to the list immediately after a successful API response.

## 7. How to Run the Application

### Backend – Spring Boot

1. Open the `API` folder in IntelliJ IDEA.
2. Make sure Java 21 is configured.
3. Run the Spring Boot application.
4. The backend starts at:

   `http://localhost:8080`

### Frontend – Angular

1. Open the `UI` folder in Visual Studio Code.
2. Open the terminal.
3. Install dependencies:

   `npm install`

4. Start the Angular application:

   `npm start`

5. Open the application in your browser:

   `http://localhost:4200`

**Note:** Make sure the backend is running before starting or using the frontend.

## 8. Testing

- **Frontend:** Manually tested in the browser.
- **Backend APIs:** Tested using Postman.
- **Backend Unit Testing:** JUnit test cases are included.
- **Integration:** Verified frontend communication with backend APIs.

CORS is configured in the backend controller to allow requests from `http://localhost:4200`.

## 9. Screenshots

Screenshots of the application UI and API testing are included in the `screenshots` folder for reference.
