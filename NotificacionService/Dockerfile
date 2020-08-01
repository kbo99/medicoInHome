FROM openjdk:12
VOLUME /tmp
ADD ./target/NotificacionService-0.0.1-SNAPSHOT.jar notificacion-service.jar
ENTRYPOINT ["java","-jar","/notificacion-service.jar"]