FROM openjdk:11-jre-slim



EXPOSE 80
ENTRYPOINT ["java", "-jar", "gestion-station-ski-1.0.jar"]

