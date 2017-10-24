echo 'asdf' | sudo -S docker stop mykbop_web
echo 'asdf' | sudo -S docker rm mykbop_web
echo 'asdf' | sudo -S docker rmi kbop_web

# docker构建
cd ..
gradle assemble
cd docker
cp ../build/libs/kbop_web.jar ./

echo 'asdf' | sudo -S docker build -t kbop_web . &&
echo 'asdf' | sudo -S docker run --link=mymysql:mysqlserver -p 8082:8082 -p 8081:8081 -d --name mykbop_web kbop_web