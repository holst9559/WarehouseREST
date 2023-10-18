FROM ubuntu:latest
LABEL authors="holst"
COPY target/WarehouseREST-1.0-SNAPSHOT.war /
ENTRYPOINT ["top", "-b"]