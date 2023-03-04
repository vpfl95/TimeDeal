FROM adoptopenjdk/openjdk11
RUN mkdir /app
WORKDIR /app
COPY . .
RUN  mvn -f pom.xml clean package
RUN ls
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} app.jar
RUN ls
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080