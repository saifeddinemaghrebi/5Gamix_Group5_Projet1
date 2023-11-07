FROM openjdk:11
EXPOSE 8089
ADD target/gestion-station-ski-1.0.jar 5Gamix_Group5_Projet1.jar
ENTRYPOINT ["java", "-jar", "5Gamix_Group5_Projet1.jar"]