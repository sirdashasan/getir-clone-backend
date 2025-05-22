FROM openjdk:17-jdk-slim

COPY target/stock-service-*.jar app.jar

COPY .env .env

ENTRYPOINT ["java","-jar","/app.jar"]
