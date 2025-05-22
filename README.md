# 🛍️ Getir Clone – Backend (Microservices Architecture)

This is the **backend** of the Getir Clone project, designed with a clean microservices architecture using **Spring Boot** and **Spring Cloud**. Each core domain (Product, Category, Subcategory, Auth) is implemented as an independent service, communicating via **Feign Clients** and exposed through a centralized **API Gateway**.

👉 You can view the [React-based frontend of this project here](https://github.com/sirdashasan/getir-clone).

## ⚙️ Architecture Overview

- 🧱 **Microservices**:
    - `product-service`: Manages products and their metadata.
    - `category-service`: Manages product categories.
    - `subcategory-service`: Handles subcategory logic with category relationships.
    - `auth-service`: Handles user authentication and authorization with JWT.
    - `stock-service`: Manages stock creation and deletion based on product lifecycle events.
- 🌐 **API Gateway**:
    - Centralized routing via **Spring Cloud Gateway**
    - Filters requests with a custom `JwtAuthGlobalFilter`
- 🔗 **Service Communication**:
    - **Feign Clients** used for inter-service validation (e.g., product → category)
    - **RabbitMQ** used for asynchronous communication between `product-service` and `stock-service`
- 🔒 **Security**:
    - JWT-based authentication
    - Role-based access control (`ROLE_USER`, `ROLE_ADMIN`) via API Gateway
- 🐳 **Dockerized**:
    - Each service is containerized for easy orchestration and testing
- 📦 **Validation & Error Handling**:
    - DTO validation with Spring Validator
    - Centralized exception handling in each service


## 🚀 Technologies Used

- **Java 17 & Spring Boot** 

- **Spring MVC, Spring Data JPA, Spring Security, Spring Cloud Gateway**

- **JWT, Role-Based Access Control**

- **Feign Client**

- **PostgreSQL**

- **RabbitMQ, Docker & Docker Compose**

- **Maven**

- **Lombok, dotenv-java** 


## 🐳 Installation & Running

```bash
# 1. Clone the repository
git clone https://github.com/sirdashasan/getir-clone-backend.git
cd getir-clone-backend

# 2. Build Each Service
cd common-dto
mvn clean install -DskipTests

cd ../auth-service
mvn clean install -DskipTests

cd ../category-service
mvn clean install -DskipTests

cd ../subcategory-service
mvn clean install -DskipTests

cd ../product-service
mvn clean install -DskipTests

cd ../stock-service
mvn clean install -DskipTests

cd ../api-gateway
mvn clean install -DskipTests


# 3. Run All Services with Docker Compose
cd ..
docker-compose up --build

```

# ⚙️ Environment Configuration (.env Files)
- **Root Directory:** .env → Used for PostgreSQL container setup
- ***api-gateway:*** .env → Contains JWT_SECRET for token verification
- ***auth-service:*** .env → Contains DB connection details and JWT_SECRET
- ***category-service, product-service, subcategory-service, stock-service:*** Each should include a .env file with database connection variables (DB_URL, DB_USERNAME, DB_PASSWORD)

## 🧱 Microservices List

| Service            | Port  | Path Prefix       | Description                           |
|--------------------|-------|-------------------|---------------------------------------|
| `auth-service`     | 8084  | `/getir/api/auth` | Auth, register, login, roles          |
| `product-service`  | 8081  | `/getir/api/products` | Product management with category/subcategory validation |
| `category-service` | 8082  | `/getir/api/categories` | Handles CRUD for categories          |
| `subcategory-service` | 8083 | `/getir/api/subcategories` | CRUD for subcategories with linkage  |
| `stock-service`     | 8085  | `/getir/api/stocks` | Handles stock creation/deletion via RabbitMQ |
| `api-gateway`      | 8080  | `/`               | Routes all requests to target services |
