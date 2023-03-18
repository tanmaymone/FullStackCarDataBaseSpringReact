FROM adoptopenjdk/openjdk18:latest
VOLUME /tmp
EXPOSE 8081
ARG JAR FILE
COPY target/car-data-base-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT [“java","-jar","/app.jar"]