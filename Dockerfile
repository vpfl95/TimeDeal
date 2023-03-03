FROM adoptopenjdk/openjdk11
ARG JAR_FILE=*.jar
COPY ./target/TimeDeal-0.0.1-SNAPSHOT.jar /target/TimeDeal-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/target/TimeDeal-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080