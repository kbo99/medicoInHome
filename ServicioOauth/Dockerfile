FROM openjdk:12
VOLUME /tmp
ADD ./target/servicio-oauth-0.0.1-SNAPSHOT.jar servicio-oaut.jar
ENTRYPOINT ["java","-jar","/servicio-oaut.jar"]