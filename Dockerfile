FROM adoptopenjdk/openjdk11
RUN mkdir /app
WORKDIR /app
COPY . .
RUN  mvn -B package --file pom.xml
RUN ls
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} app.jar
RUN ls
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080