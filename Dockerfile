FROM openjdk:11-jre-slim

ADD target/gestion-station-ski-1.0.jar gestion-station-ski-1.0.jar
EXPOSE 80
ENTRYPOINT ["java", "-jar", "/gestion-station-ski-1.0.jar"]