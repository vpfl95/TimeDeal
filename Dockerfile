FROM openjdk:11
RUN ls
RUN cd home/runner/work/TimeDeal
RUN ls
RUN cd tmp
RUN ls
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080