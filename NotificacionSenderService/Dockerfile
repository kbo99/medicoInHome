FROM openjdk:12
VOLUME /tmp
EXPOSE 8014
ADD ./target/NotificacionSenderService-0.0.1-SNAPSHOT.jar notificacion-sender-service.jar
ENTRYPOINT ["java","-jar","/notificacion-sender-service.jar"]