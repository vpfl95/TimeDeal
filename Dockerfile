FROM adoptopenjdk/openjdk11

ENTRYPOINT ["java","-jar","target/TimeDeal-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080