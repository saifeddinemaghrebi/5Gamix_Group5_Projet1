FROM alpine
RUN apk add openjdk11
EXPOSE 80
CMD ["java", "-jar", "gestion-station-ski-1.0.jar"]