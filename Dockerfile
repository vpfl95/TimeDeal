FROM adoptopenjdk/openjdk11
RUN mkdir /app
WORKDIR /app
COPY . .
RUN chmod +x mvnw
RUN  ./mvnw clean install
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
RUN ls
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080