# kbop_web

### 环境配置

硬盘: > 5G
内存: > 1G
tomcat: 8.5+
jetty:9.4
gradle: 3.5
jdk: 1.8
spring: 4.3.8
spring boot: 1.5.7
MySQL: 5.7
docker: > 17


### 简介
- 使用RESTful API
- SWAGGER UI 用于API文档


### Swagger
api 文档json: `http://localhost:8081/v2/api-docs`
api 文档页面: `http://localhost:8081/swagger-ui.html`

### docker

Dockerfile

```
FROM openjdk
VOLUME /tmp
COPY kbop_web.jar /home/
EXPOSE 8081 8081
ENV JAVA_OPTS=""
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /home/kbop_web.jar
```

```bash
docker stop $(docker ps -a -q); \
docker rm $(docker ps -a -q); \
docker rmi kbop_web; \
docker build -t kbop_web .; \ 
docker run -p 8081:8081 -d kbop_web
```