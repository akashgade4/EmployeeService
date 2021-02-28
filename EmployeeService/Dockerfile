FROM openjdk:8-jdk-alpine
RUN mkdir -p /opt/student/lib
COPY target/EmployeeService-0.0.1-SNAPSHOT.jar /opt/student/EmployeeService-0.0.1-SNAPSHOT.jar
#COPY target/lib/* /opt/student/lib/
ENTRYPOINT ["java","-jar","/opt/student/EmployeeService-0.0.1-SNAPSHOT.jar"]

