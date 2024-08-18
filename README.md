
# User Session Management

This project is a Spring Boot-based application for managing user sessions with Redis integration. It provides features for user registration, login, and logout, with session management handled by Redis for performance and scalability.

## Features

- **User Registration**: Register new users with a secure password hashing mechanism.
- **User Login**: Authenticate users and create a session that is stored in Redis.
- **Session Management**: Manage user sessions with Redis, including automatic session expiration after 2 minutes of inactivity.
- **User Logout**: Securely log out users and delete their session from Redis.

## Technologies Used

- **Spring Boot**: The foundation of the application.
- **Redis**: Used for session management.
- **Spring Security**: Provides authentication and security mechanisms.
- **Hibernate**: ORM tool used for database interactions.
- **MySQL**: The relational database management system used to store user data.

## Project Setup

### Configuration
The application requires minimal configuration as most settings are predefined in the `application.properties` file. However, you may need to update the following configurations depending on your environment:

```properties
# Redis configuration
spring.redis.host=localhost
spring.redis.port=6379

# Hibernate configurations
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
```

### Database
While Redis is used for session management, the user data is stored in a relational database. You can configure the database connection details in the `application.properties` file:

```properties
# Database configuration
spring.datasource.url=jdbc:mysql://localhost:3306/userdb
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

## Security

The application uses Spring Security for authentication and session management. Passwords are securely hashed using BCrypt before being stored in the database. 

### Password Encryption
The project uses Spring Security's BCryptPasswordEncoder for encrypting user passwords. This ensures that stored passwords are securely hashed.

### Session Timeout
Sessions are automatically invalidated after 2 minutes of inactivity. This helps prevent unauthorized access if a user forgets to log out.

## Deployment

### Docker
You can deploy the application using Docker for easier management and scalability. Below is a simple `Dockerfile` to get you started:

```dockerfile
# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the working directory
WORKDIR /app

# Copy the application JAR file to the container
COPY target/user-session-management-0.0.1-SNAPSHOT.jar /app/user-session-management.jar

# Expose the port the app runs on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "user-session-management.jar"]
```

You can build and run the Docker image with the following commands:

```bash
docker build -t user-session-management .
docker run -p 8080:8080 user-session-management
```

## Troubleshooting

### Common Issues
1. **Redis Connection Issues**:
    - Ensure that Redis is running and accessible on the configured host and port.
    - Check firewall settings if Redis is hosted remotely.
    
2. **Session Expiration**:
    - Ensure that the Redis TTL (time-to-live) is correctly set to 2 minutes.

3. **Database Connection Issues**:
    - Double-check the database connection URL, username, and password.
    - Ensure that the MySQL service is running.

### Logs
Application logs are available in the console output by default. You can configure log levels in the `application.properties` file:

```properties
# Logging configuration
logging.level.org.springframework=INFO
logging.level.com.companyname=DEBUG
```

## Documentation

### API Documentation
You can generate API documentation using tools like Swagger. Integrating Swagger into this project can provide a user-friendly interface for testing and interacting with the API.

To integrate Swagger, add the following dependencies to your `pom.xml`:

```xml
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-boot-starter</artifactId>
    <version>3.0.0</version>
</dependency>
```

Once integrated, you can access the Swagger UI at `http://localhost:8080/swagger-ui/`.

## Conclusion

This project serves as a robust foundation for managing user sessions in a Spring Boot application using Redis. With a focus on security and scalability, this system can be extended and adapted to meet various use cases in real-world applications.

For any questions, issues, or contributions, please open an issue or submit a pull request on the [GitHub repository](https://github.com/unknown1fsh/user-session-management).
