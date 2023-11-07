FROM maven:3.8.4-openjdk-17 as maven-builder
WORKDIR /app
COPY pom.xml .
COPY src ./src

FROM openjdk:17-alpine
COPY --from=maven-builder /app/target/gestion-station-ski-1.0.jar /gestion-station-ski-1.0.jar
EXPOSE 80
CMD ["java", "-jar", "/gestion-station-ski-1.0.jar"]
