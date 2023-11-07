FROM maven:3.8.4 AS maven-builder
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn package

FROM openjdk:11-jre-slim
COPY --from=maven-builder /app/target/gestion-station-ski-1.0.jar /gestion-station-ski-1.0.jar
EXPOSE 80
CMD ["java", "-jar", "/gestion-station-ski-1.0.jar"]
