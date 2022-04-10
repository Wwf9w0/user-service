FROM openjdk:8
<<<<<<< HEAD
ADD target/user-service.jar user-service.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "user-service.jar"]

=======
ADD target/user-service-0.0.1-SNAPSHOT.jar user-service-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "user-service-0.0.1-SNAPSHOT.jar"]
>>>>>>> 0c39a2a (minor)
