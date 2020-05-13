FROM openjdk:11
ADD target/produtos-service.jar produtos-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "produtos-service.jar"]