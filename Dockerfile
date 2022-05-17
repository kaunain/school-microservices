FROM openjdk:11
VOLUME /tmp
EXPOSE 8081
ADD student/target/student-0.0.1-SNAPSHOT.jar student-0.0.1-SNAPSHOT.jar 
ENTRYPOINT ["java","-jar","/student-0.0.1-SNAPSHOT.jar"]

