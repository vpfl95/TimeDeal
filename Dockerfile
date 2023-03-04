FROM adoptopenjdk/openjdk11
RUN mkdir /app
WORKDIR /app

ARG JAR_FILE=*.jar
COPY target app.jar
RUN ls
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080