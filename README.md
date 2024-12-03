## Introduction

The Task Management System is a Spring Boot application designed to build RESTful APIs and integrate them with a database. It allows users to perform basic operations like creating, updating, deleting, and retrieving tasks, offering a hands-on experience in building a functional project.

## Key Features

- Perform CRUD (Create, Read, Update, Delete) operations on tasks.
- Store and retrieve tasks from a PostgreSQL database.
- Integrate with Spring Boot and implement RESTful APIs.
- Pagination and Serialization for better data handling.

## Prerequisites

Install the following applications on your system:

- **Java 17**
- **Maven**
- **PostgreSQL**
- **IntelliJ IDEA**

## Getting Started

### Download the Project from Spring Initializr

1. Visit the [Spring Initializr](https://start.spring.io/) website.
2. Configure the project settings:
    - **Project**: Maven
    - **Language**: Java
    - **Spring Boot Version**: The latest stable version.
    - **Dependencies**:
        - Spring Web
        - Spring Data JPA
        - PostgreSQL Driver
    - **Group**: `com.task`
    - **Artifact**: `task-management`
    - **Name**: `TaskManagement`
    - **Description**: `Task Management Spring Boot application`
    - **Package Name**: `com.task.TaskManagement`
    - **Java Version**: 17
3. Click the **Generate** button to download the project.
4. Extract the downloaded project to your desired location.

### Open the Project

1. Open IntelliJ IDEA.
2. Navigate to **File > Open**, then select the extracted project directory.

## Configure the Database

1. Open the `src/main/resources/application.properties` file.
2. Add the following properties:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5433/task_management
   spring.datasource.username=your-username
   spring.datasource.password=your-password
   spring.datasource.driver-class-name=org.postgresql.Driver
   spring.jpa.hibernate.ddl-auto=update

## Project Structure
My project structure is structured as:

- **`TaskManagementApplication.java`**: This is the entry point for the Spring Boot application.
- **`controller/TaskController.java`**: This will Manage the RESTful API requests for CRUD operations.
- **`entity/TaskEntity.java`**: Defines the Task entity.
- **`repository/TaskRepository.java`**: Interfaces with the database using Spring Data JPA.
- **`exceptionhandling/GlobalExceptionHandler.java`**: Provides global exception handling for the application.
- **`application.properties`**: Contains all the configurations like database connection details.

## API Endpoints

### Task Management APIs

| Method | Endpoint         | Description               |
|--------|------------------|---------------------------|
| GET    | `/tasks/search?page={page}&size={size}` | Retrieve all tasks        |
| GET    | `/tasks/{id}`    | Retrieve a task by ID     |
| POST   | `/tasks`         | Create a new task         |
| PUT    | `/tasks/{id}`    | Update an existing task   |
| DELETE | `/tasks/{id}`    | Delete a task             |

## Running the Application

1. Open IntelliJ IDEA.
2. Navigate to **TaskManagementApplication**.
3. Click **Run** to start the application.

## Postman Testing

### POST Endpoint

1. Open Postman.
2. Select **POST**.
3. Enter the URL: `http://localhost:8080/tasks`.
4. ```
   {
   "title": "Spring Boot Application Status",
   "description": "Application is running successfully",
   "status": "Compleleted"
   }

5. Click **Send**.

### GET Endpoint

1. Select **GET**.
2. Enter the URL: `http://localhost:8080/tasks/search?page=0&size=10`.
3. Click **Send**.

### PUT Endpoint

1. Select **PUT**.
2. Enter the URL: `http://localhost:8080/tasks/{id}`.
3. ```
   {
    "Status": "Completed"
   }
4. Click **Send**.

### DELETE Endpoint

1. Select **DELETE**.
2. Enter the URL: `http://localhost:8080/tasks/{id}`.
3. Click **Send**.

## Conclusion

The Task Management API meets the project requirements by implementing the following features:

1. **CRUD Operations**: Supports Create, Read, Update, and Delete operations for tasks.
2. **Task Status Management**: Allows users to update task statuses.
3. **Validation**: Includes validation for task title, description, and status.
4. **Pagination**: Implements pagination to handle large datasets.
5. **Error Handling**: Handles exceptions and returns appropriate error responses.

