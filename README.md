# JWT Security Project

This project demonstrates a secure REST API built with Spring Boot, utilizing JSON Web Tokens (JWT) for authentication and authorization. It features user registration, login, token refresh, and a basic product management system.

## Features

*   **User Registration:** Allows new users to register with a username, password, and role.
*   **User Login:** Authenticates users and returns an access token and a refresh token.
*   **Token Refresh:** Provides a mechanism to refresh access tokens using refresh tokens.
*   **JWT-Based Authentication:** Secures API endpoints using JWTs.
*   **Role-Based Authorization:**  Supports different user roles (though not explicitly demonstrated in the provided code).
*   **Product Management:** Basic CRUD operations for products (create, read, update, delete).
*   **PostgreSQL Database:** Stores user and product data in a PostgreSQL database.
*   **Validation:** Implements input validation for request payloads.

## Technologies

*   **Spring Boot:** The core framework for building the application.
*   **Spring Security:** Handles authentication and authorization.
*   **Spring Data JPA:** Simplifies database interactions.
*   **PostgreSQL:** The relational database management system.
*   **JSON Web Tokens (JWT):** Used for secure authentication.
*   **io.jsonwebtoken (JJWT):** A library for creating and parsing JWTs.
*   **Lombok:** Reduces boilerplate code.
*   **Maven:** Build tool for dependency management and project building.
* Java 17 or higher

## Setup and Installation

1.  **Prerequisites:**
    *   Java Development Kit (JDK) 17 or higher
    *   Maven
    *   PostgreSQL database installed and running.

2.  **Clone the repository:**
    ```bash
    git clone https://github.com/learnwithiftekhar/Spring-Security-JWT
    cd Spring-Security-JWT
    ```

3.  **Database Configuration:**
    *   Open `src/main/resources/application.properties`.
    *   Update the PostgreSQL connection details (`spring.datasource.url`, `spring.datasource.username`, `spring.datasource.password`) to match your database setup.
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/<DATAVASE-NAME>
    spring.datasource.username=<USERNAME>
    spring.datasource.password=<PASSWORD>
    ```
    *    The application is set to create and drop tables on start up, using: `spring.jpa.hibernate.ddl-auto=create-drop`. Change to `spring.jpa.hibernate.ddl-auto=update` if you wish the data to be persisted.

4.  **JWT Secret:**
    *   The `app.jwt.secret` property in `application.properties` contains a long, randomly generated string. **Keep this secret safe and secure in production.**
     ```properties
     app.jwt.secret=very-secure-and-complex-key-that-is-at-least-256-bits-long-for-production
     ```

5. **Build and Run:**
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

   The application will start on `http://localhost:8080` (default Spring Boot port).

## API Endpoints

*   **POST /api/auth/register:**
    *   Registers a new user.
    *   Request Body:
        ```json
        {
          "username": "newuser",
          "password": "newpassword",
          "role": "ROLE_USER"
        }
        ```
    * `role` is optional, if not provided, default role will be `USER`.
   

*   **POST /api/auth/login:**
    *   Logs in a user and returns JWT tokens.
    *   Request Body:
        ```json
        {
          "username": "existinguser",
          "password": "userpassword"
        }
        ```

*   **POST /api/auth/refresh-token:**
    *   Refreshes an access token using a refresh token.
    *   Request Body:
    ```json
    {
      "refreshToken": "eyJhbGciOiJIUzUxMiJ9..."
    }
    ```
*   **GET /api/products:**
    *   Retrieves all products.
    *   Requires a valid access token.
* **GET /api/products/{id}:**
    *   Retrieves product by id.
    *   Requires a valid access token.
* **POST /api/products:**
    * create new product
    * Request body example:
    ```json
        {
            "name": "product name",
            "price": 10
        }
    ```
    *   Requires a valid access token.
*   **DELETE /api/products/{id}**:
    * Delete product by id.
    *   Requires a valid access token.

## Further Development

*   **More detailed error handling:** Improve error handling and provide more informative error messages.
*   **Comprehensive testing:** Add unit and integration tests.
*   **Enhanced security:** Consider additional security measures, such as input sanitization and rate limiting.
*   **Role based authorization**
* **Validation for all entities**
*   **Product update**

