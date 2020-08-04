FROM openjdk:12
VOLUME /tmp
EXPOSE 8888
ADD ./target/AdministracionService-0.0.1-SNAPSHOT.jar servicio-admin.jar
ENTRYPOINT ["java","-jar","/servicio-admin.jar"]