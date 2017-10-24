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

### druid

监控页面 `/druid/`

账号密码
`kbop 980c9b2d5336f2bf`

### jmx

端口:`127.0.0.1:8082`

### docker

mysql
```bash
docker run --name mymysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=JNaRKZytA7PpbrXe -d mysql ;
mysql -h 127.0.0.1 -uroot -pJNaRKZytA7PpbrXe -e "create user casxter@'%' identified by 'JNaRKZytA7PpbrXe'" ;
mysql -h 127.0.0.1 -uroot -pJNaRKZytA7PpbrXe -e "grant ALL on *.* to casxter@'%'" ;
mysql -h 127.0.0.1 -uroot -pJNaRKZytA7PpbrXe -e "flush privileges;"
```

kbop_web

Dockerfile -> ./docker/Dockerfile

sh -> ./docker/rerunDocker.sh
