FROM openjdk:8-alpine
MAINTAINER Abhinav
COPY ./target/calculatorspe-1.0-SNAPSHOT-jar-with-dependencies.jar ./
WORKDIR ./
CMD ["java","-jar","calculatorspe-1.0-SNAPSHOT-jar-with-dependencies.jar"]
