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
    *   You can generate a secure secret key using the following command:
     ```bash
     openssl rand -base64 64
     ```
     ```properties
     app.jwt.secret=very-secure-and-complex-key-that-is-at-least-256-bits-long-for-production
     ```

5. **Build and Run:**
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

   The application will start on `http://localhost:8080` (default Spring Boot port).

## API Endpoints Summary

| Category | Method | Endpoint | Description | Auth Required |
| :--- | :--- | :--- | :--- | :--- |
| Authentication | POST | `/api/auth/register` | Register a new user | No |
| Authentication | POST | `/api/auth/login` | Login and get tokens | No |
| Authentication | POST | `/api/auth/refresh-token` | Refresh access token | No |
| Products | GET | `/api/products` | Get all products | Yes (Any) |
| Products | GET | `/api/products/{id}` | Get product by ID | Yes (Any) |
| Products | POST | `/api/products` | Create a new product | Yes (Admin) |
| Products | PUT | `/api/products/{id}` | Update a product | Yes (Admin) |
| Products | DELETE | `/api/products/{id}` | Delete a product | Yes (Admin) |

## API Endpoints and curl Requests

### Authentication

#### 1. Register User
**POST** `/api/auth/register`

Registers a new user.

**curl Request:**
```bash
curl -X POST http://localhost:8080/api/auth/register \
     -H "Content-Type: application/json" \
     -d '{
           "fullName": "John Doe",
           "username": "johndoe",
           "password": "password123",
           "role": "ROLE_ADMIN"
         }'
```

#### 2. Login
**POST** `/api/auth/login`

Authenticates a user and returns an access token and a refresh token.

**curl Request:**
```bash
curl -X POST http://localhost:8080/api/auth/login \
     -H "Content-Type: application/json" \
     -d '{
           "username": "johndoe",
           "password": "password123"
         }'
```

#### 3. Refresh Token
**POST** `/api/auth/refresh-token`

Generates a new access token using a valid refresh token.

**curl Request:**
```bash
curl -X POST http://localhost:8080/api/auth/refresh-token \
     -H "Content-Type: application/json" \
     -d '{
           "refreshToken": "YOUR_REFRESH_TOKEN_HERE"
         }'
```

---

### Products

All product endpoints require a valid **Access Token** in the `Authorization` header.

#### 4. Get All Products
**GET** `/api/products`

Retrieves a list of all products.

**curl Request:**
```bash
curl -X GET http://localhost:8080/api/products \
     -H "Authorization: Bearer YOUR_ACCESS_TOKEN_HERE"
```

#### 5. Get Product by ID
**GET** `/api/products/{id}`

Retrieves a single product by its ID.

**curl Request:**
```bash
curl -X GET http://localhost:8080/api/products/1 \
     -H "Authorization: Bearer YOUR_ACCESS_TOKEN_HERE"
```

#### 6. Create Product (Admin Only)
**POST** `/api/products`

Creates a new product. Requires `ROLE_ADMIN`.

**curl Request:**
```bash
curl -X POST http://localhost:8080/api/products \
     -H "Content-Type: application/json" \
     -H "Authorization: Bearer YOUR_ACCESS_TOKEN_HERE" \
     -d '{
           "name": "Laptop",
           "price": 1200.00
         }'
```

#### 7. Update Product (Admin Only)
**PUT** `/api/products/{id}`

Updates an existing product. Requires `ROLE_ADMIN`.

**curl Request:**
```bash
curl -X PUT http://localhost:8080/api/products/1 \
     -H "Content-Type: application/json" \
     -H "Authorization: Bearer YOUR_ACCESS_TOKEN_HERE" \
     -d '{
           "name": "Updated Laptop",
           "price": 1100.00
         }'
```

#### 8. Delete Product (Admin Only)
**DELETE** `/api/products/{id}`

Deletes a product by its ID. Requires `ROLE_ADMIN`.

**curl Request:**
```bash
curl -X DELETE http://localhost:8080/api/products/1 \
     -H "Authorization: Bearer YOUR_ACCESS_TOKEN_HERE"
```

## Further Development

*   **More detailed error handling:** Improve error handling and provide more informative error messages.
*   **Comprehensive testing:** Add unit and integration tests.
*   **Enhanced security:** Consider additional security measures, such as input sanitization and rate limiting.
*   **Role based authorization**
*   **Validation for all entities**

