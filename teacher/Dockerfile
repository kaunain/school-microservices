FROM openjdk:11
VOLUME /tmp
EXPOSE 8082
ADD target/teacher-0.0.1-SNAPSHOT.jar teacher-0.0.1-SNAPSHOT.jar 
ENTRYPOINT ["java","-jar","/teacher-0.0.1-SNAPSHOT.jar"]

