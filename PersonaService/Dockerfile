FROM openjdk:12
VOLUME /tmp
ADD ./target/persona-service-0.0.1-SNAPSHOT.jar persona-service.jar
ENTRYPOINT ["java","-jar","/persona-service.jar"]