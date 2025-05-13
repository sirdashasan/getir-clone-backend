FROM openjdk:17-jdk-slim
COPY target/api-gateway-*.jar app.jar
COPY .env .env
ENTRYPOINT ["java", "-jar", "/app.jar"]