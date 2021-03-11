FROM openjdk:8-alpine
COPY ./target/calculatorspe-1.0-SNAPSHOT-jar-with-dependencies ./
WORKDIR ./
CMD ["java","-jar","calculatorspe-1.0-SNAPSHOT-jar-with-dependencies"]
