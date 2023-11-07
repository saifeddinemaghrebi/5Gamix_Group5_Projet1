FROM alpine
RUN apk add openjdk11

COPY ./target/gestion-station-ski-1.0.jar /
EXPOSE 80
CMD ["java", "-jar", "gestion-station-ski-1.0.jar"]