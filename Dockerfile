# Set the base image
FROM openjdk:8-alpine
# File Author
MAINTAINER Abhinav
# Copies the files from the source on the host into the container’s set destination
COPY ./target/calculatorspe-1.0-SNAPSHOT-jar-with-dependencies.jar ./
# Set Working Directory
WORKDIR ./
# Default container command to execute the program
CMD ["java","-jar","calculatorspe-1.0-SNAPSHOT-jar-with-dependencies.jar"]