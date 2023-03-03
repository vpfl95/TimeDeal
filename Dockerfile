FROM adoptopenjdk/openjdk11
CMD ["./mvnw", "clean", "package"]
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
EXPOSE 8080