FROM adoptopenjdk/openjdk11
RUN mkdir /app
WORKDIR /app
RUN mvnw clean package
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} app.jar
RUN ls
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080