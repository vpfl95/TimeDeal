FROM adoptopenjdk/openjdk11
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} app.jar

EXPOSE 8080