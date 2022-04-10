FROM openjdk:8
ADD target/user-service-0.0.1-SNAPSHOT.jar user-service-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "user-service-0.0.1-SNAPSHOT.jar"]