FROM maven:3.8.4-openjdk-17 as maven-builder
WORKDIR /app
COPY pom.xml .
COPY src ./src

FROM openjdk:17-alpine
EXPOSE 80
CMD ["java", "-jar", "/gestion-station-ski-1.0.jar"]
