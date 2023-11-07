FROM alpine
RUN apk add openjdk11
COPY ./target/myapp-.jar /
EXPOSE 80
CMD ["java", "-jar", "/myapp.jar"]