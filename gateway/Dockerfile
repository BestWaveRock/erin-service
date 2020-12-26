FROM java:openjdk-8-jre-alpine as build
VOLUME /tmp
ARG JAR_FILE
# java
ENV JAVA_OPTS="-Xms1g -Xmx1g -Duser.timezone=GMT+08" \
BASE_SERVICES="base-service.default.svc.cluster.local" \
USER_SERVICES="user-service.default.svc.cluster.local" \
GOODS_SERVICES="goods-service.default.svc.cluster.local" \
APP_SERVICES="app-service.default.svc.cluster.local" \
THIRD_PARTY_SERVICES="third-party-service.default.svc.cluster.local" \
ORDER_SERVICES="order-service.default.svc.cluster.local" \
INVENTORY_SERVICES="inventory-service.default.svc.cluster.local" \
INFO_SERVICES="info-service.default.svc.cluster.local" \
SCHEDULE_SERVICES="schedule-service.default.svc.cluster.local" \
MESSAGES_ERVICES="message-service.default.svc.cluster.local" \
PROFILE="docker"

EXPOSE 8000

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar --spring.profiles.active=$PROFILE" ]

ADD ${JAR_FILE} app.jar
# 这步作用是改变文件时间
RUN sh -c 'touch /app.jar'
