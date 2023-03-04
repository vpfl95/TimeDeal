FROM adoptopenjdk/openjdk11
RUN chmod +x mvnw
RUN  ./mvnw clean install
RUN mkdir /app
WORKDIR /app
COPY . .
RUN ls
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080