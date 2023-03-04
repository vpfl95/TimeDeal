FROM adoptopenjdk/openjdk11
ARG JAR_FILE=target/*.war
COPY ${JAR_FILE} /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080