## Pizza Creed Application Setup Guide

### Introduction
Welcome to the Pizza Creed backend application! This project is built with the Spring Framework and provides a REST API for managing pizza products and orders. Follow the steps below to set up and run the application.

### Prerequisites
Before you begin, ensure you have the following installed on your system:

- JDK 17 or higher
- Maven
- MySQL
- postman

### Database Setup
1. **Create a Database**:
   Set up a database for the application. You can use any RDBMS you prefer. For example, using MySQL:
   ```sql
   CREATE DATABASE pizzacreed;
   ```

2. **Configure Database Credentials**:
   Update the `application.properties` file with your database connection details. This file is located in the `src/main/resources` application.
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/pizzacreed
   spring.datasource.username=root
   spring.datasource.password=
   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
   logging.level.org.springframework=DEBUG
   server.port=8080
   spring.application.name=pizzacreed
   spring.thymeleaf.suffix=.html
   spring.thymeleaf.cache=false
   logging.level.com.EAD2.pizzacreed=DEBUG
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
- Access the admin console at `http://localhost:8080`.
- Use the admin login to add, edit, or delete pizza products.

### Testing the API
A collection of POSTMAN test cases is included in the `postman` directory of the repository. You can also [download the POSTMAN collection here](https://www.postman.com/martian-zodiac-853057/workspace/pizzacreedglobal/collection/31839030-48427e2f-b825-413f-a1fa-33dc6f882834?action=share&creator=34104620) to import and test the API endpoints.


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
For any questions or feedback, please contact `prasadkau97@gmail.com`.
