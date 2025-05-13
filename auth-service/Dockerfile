FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/auth-service-*.jar app.jar
COPY .env .env
ENTRYPOINT ["java", "-jar", "app.jar"]