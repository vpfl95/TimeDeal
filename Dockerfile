FROM adoptopenjdk/openjdk11
RUN mkdir /app
WORKDIR /app
COPY . .

Run ls
ARG JAR_FILE=target/*.jar
RUN cp ${JAR_FILE} /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080