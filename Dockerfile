From openjdk:11
copy ./target/student-0.0.1-SNAPSHOT.jar student-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","student-0.0.1-SNAPSHOT.jar"]