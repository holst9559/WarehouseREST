FROM bitnami/wildfly:29.0.1
ENV WILDFLY_USERNAME=user, WILDFLY_PASSWORD=password
LABEL authors="holst"
COPY target/WarehouseREST-1.0-SNAPSHOT.war /app