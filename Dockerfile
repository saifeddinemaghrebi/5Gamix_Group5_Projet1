FROM openjdk:11-jre-slim


EXPOSE 8089
ENTRYPOINT ["java", "-jar", "gestion-station-ski-1.0.jar"]

