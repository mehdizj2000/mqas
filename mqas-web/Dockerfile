FROM openjdk:8-jdk

ARG APP_PORT="8892"
ARG SPRING_DATASOURCE_URL="jdbc:postgresql://pgress:5432/postgres?currentSchema=mqas_test"
ARG SPRING_DATASOURCE_PASSWORD="123456"
ARG SOLR_API_URL=http://127.0.0.1:8595/api/getAddress/

VOLUME /tmp

ENV APP_USER="mehdi" \
    APP_UID=$APP_PORT \
    APP_GROUP="mehdi" \
    APP_GID=$APP_PORT \
    APP_WORKING_DIR="/opt/appdir/" \
    SPRING_DATASOURCE_URL="$SPRING_DATASOURCE_URL" \
    SPRING_DATASOURCE_PASSWORD="$SPRING_DATASOURCE_PASSWORD" \
    MQAS_SOLR_API_URL="$SOLR_API_URL"   

RUN set -ex; \
  groupadd -r --gid "$APP_GID" "$APP_GROUP"; \
  useradd -r --uid "$APP_UID" --gid "$APP_GID" "$APP_USER"; \
  usermod -aG root "$APP_USER"; \
  mkdir "$APP_WORKING_DIR"; \
  chown -R "$APP_USER":"$APP_GROUP" "$APP_WORKING_DIR" 

WORKDIR "$APP_WORKING_DIR"

USER "$APP_USER" 

EXPOSE "$APP_PORT"

ARG JAR_FILE=target/mqas-web-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java"]
CMD ["-jar","app.jar"]
