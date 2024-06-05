To create a step-by-step guide for using the Pizza Creed application in your GitHub README file, follow these instructions. This guide will include setup, running the application, and a brief explanation of the project's structure.

## Pizza Creed Application Setup Guide

### Introduction
Welcome to the Pizza Creed backend application! This project is built with the Spring Framework and provides a REST API for managing pizza products and orders. Follow the steps below to set up and run the application.

### Prerequisites
Before you begin, ensure you have the following installed on your system:

- JDK 17 or higher
- Maven
- A suitable RDBMS (e.g., MySQL, PostgreSQL)
- Git

### Cloning the Repository
First, clone the repository from GitHub to your local machine:
```sh
git clone https://github.com/yourusername/pizza-creed.git
cd pizza-creed
```

### Database Setup
1. **Create a Database**:
   Set up a database for the application. You can use any RDBMS you prefer. For example, using MySQL:
   ```sql
   CREATE DATABASE pizza_creed_db;
   ```

2. **Configure Database Credentials**:
   Update the `application.properties` file with your database connection details. This file is located in the `src/main/resources` directory.
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/pizza_creed_db
   spring.datasource.username=yourusername
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update
   ```

### Building the Application
Use Maven to build the project. In the root directory of the project, run:
```sh
mvn clean install
```

### Running the Application
After successfully building the project, you can run the application using:
```sh
mvn spring-boot:run
```
The application should start on `http://localhost:8080`.

### Using the Application
#### Admin Web Console
- Access the admin console at `http://localhost:8080/admin`.
- Use the admin login to add, edit, or delete pizza products.

#### REST API Endpoints
The following REST API endpoints are available for managing the shopping basket:

1. **List Available Products**
   ```sh
   GET /api/products
   ```

2. **Create a Shopping Basket**
   ```sh
   POST /api/baskets
   ```

3. **Add Products to the Shopping Basket**
   ```sh
   POST /api/baskets/{basketId}/products
   ```

4. **Remove Products from the Shopping Basket**
   ```sh
   DELETE /api/baskets/{basketId}/products/{productId}
   ```

5. **View Shopping Basket**
   ```sh
   GET /api/baskets/{basketId}
   ```

6. **Checkout**
   ```sh
   POST /api/baskets/{basketId}/checkout
   ```

### Testing the API
A collection of POSTMAN test cases is included in the `postman` directory of the repository. Import this collection into POSTMAN to test the API endpoints.

### Project Structure
- **src/main/java**: Contains the Java source code.
- **src/main/resources**: Contains the application configuration files.
- **pom.xml**: Maven configuration file.
- **README.md**: Project documentation.

### Contribution
Feel free to fork the repository and submit pull requests. For major changes, please open an issue first to discuss what you would like to change.

### License
This project is licensed under the MIT License.

### Contact
For any questions or feedback, please contact `youremail@example.com`.

---

By following these steps, users will be able to set up and run the Pizza Creed backend application successfully. Ensure that all details, especially database configurations and API endpoints, are accurate and tailored to your specific implementation.
