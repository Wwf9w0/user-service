FROM openjdk:8
ADD target/social-user-service.jar social-user-service.jar
EXPOSE 8088
ENTRYPOINT ["java", "-jar", "social-user-service.jar"]
