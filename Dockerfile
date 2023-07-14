# image for PetClinic springboot application
# jar file present in target folder
# base image for openjdk jre with version  java 17
# copy jar file from target folder to docker image
# expose port 9966
# run jar file

FROM openjdk:17-jdk-alpine
COPY target/spring-petclinic-rest-3.0.2.jar spring-petclinic-rest-3.0.2.jar
EXPOSE 9966
CMD ["java","-jar","spring-petclinic-rest-3.0.2.jar"]

# build docker image
# docker build -t petclinic-rest:3.0.2 .
