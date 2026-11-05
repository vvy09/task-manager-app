# Simple Task Manager – Frontend

## Overview
This is the Angular frontend application for the Simple Task Manager. It allows users to create tasks and view all previously created tasks.

## Technologies Used
- Angular
- TypeScript
- HTML
- CSS
- Angular Reactive Forms
- Angular HttpClient

## Features
- Single-page task management interface.
- Create a task with a title and optional description.
- Task title is mandatory.
- Form validation for title and description.
- Disable the Add Task button until a valid title is entered.
- Display validation and success/error messages.
- Automatically load existing tasks when the page opens.
- Display newly created tasks immediately without refreshing the page.
- Show task creation date and time.
- Test cases are not included, verified manually.

## Backend Integration
The frontend communicates with the Spring Boot backend using Angular HttpClient.

Backend API URL:

`http://localhost:8080/api/tasks`

- GET – Loads all existing tasks.
- POST – Creates a new task.

The API communication is implemented in a separate Angular service.

## Project Structure

- `tasks/task-page` – Contains the task page component and UI.
- `services` – Contains the service responsible for backend API calls.
- `models` – Contains TypeScript interfaces for task data.
- `app.config.ts` – Configures application providers, including HttpClient.

Angular Signals are used to update the task list when data is loaded or a new task is created.

## How to Run

1. Open the `UI` folder in Visual Studio Code.
2. Open the terminal.
3. Install dependencies:

   `npm install`

4. Start the Angular application:

   `npm start`

5. Open the application in your browser:

   `http://localhost:4200`
   
## Testing
The frontend scenarios were manually tested and automated UI test cases were not included.

## Note
Make sure the Spring Boot backend is running on port 8080 before using the frontend.