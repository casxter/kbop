#!/bin/sh

##前期准备
cd ..
gradle assemble
cd docker

echo 'asdf' | sudo -S docker stop mykbop_web ||
echo 'asdf' | sudo -S docker cp ../build/libs/kbop_web.jar mykbop_web:/home/ &&
echo 'asdf' | sudo -S docker start mykbop_web