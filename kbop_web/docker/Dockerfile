FROM openjdk

VOLUME /tmp
COPY kbop_web.jar /home/
EXPOSE 8081 8081
EXPOSE 8082 8082

ENV TZ=Asia/Shanghai
ENV JAVA_OPTS="-Dcom.sun.management.jmxremote=true -Dcom.sun.management.jmxremote.port=8082 -Dcom.sun.management.jmxremote.ssl=false \
-Dcom.sun.management.jmxremote.authenticate=false -Xms512m -Xmx2048m"

RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=prod -jar /home/kbop_web.jar