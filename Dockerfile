FROM adoptopenjdk/openjdk11
RUN cd tmp && ls
RUN chmod +x mvnw
RUN  ./mvnw clean install
RUN mkdir /app
WORKDIR /app
COPY . .
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080