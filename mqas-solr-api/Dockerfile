FROM openjdk:8-jdk

ARG APP_PORT="8595"
ARG GNAF_ZK-SERVERS="node01:2181,node02:2181,node03:2181"

VOLUME /tmp

ENV APP_USER="mehdi" \
    APP_UID=$APP_PORT \
    APP_GROUP="mehdi" \
    APP_GID=$APP_PORT \
    APP_WORKING_DIR="/opt/appdir/" \
    GNAF_ZK-SERVERS="$GNAF_ZK-SERVERS"

RUN set -ex; \
  groupadd -r --gid "$APP_GID" "$APP_GROUP"; \
  useradd -r --uid "$APP_UID" --gid "$APP_GID" "$APP_USER"; \
  usermod -aG root "$APP_USER"; \
  mkdir "$APP_WORKING_DIR"; \
  chown -R "$APP_USER":"$APP_GROUP" "$APP_WORKING_DIR" 

WORKDIR "$APP_WORKING_DIR"

USER "$APP_USER" 

EXPOSE "$APP_PORT"

ARG JAR_FILE=target/mqas-solr-api-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java"]
CMD ["-jar","app.jar"]
