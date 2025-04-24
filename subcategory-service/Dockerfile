# Use a Java 17 based image
FROM openjdk:17-jdk-slim

# Copy the application jar file
COPY target/subcategory-service-*.jar app.jar

# Copy the .env file
COPY .env .env

# Run the application
ENTRYPOINT ["java","-jar","/app.jar"]
