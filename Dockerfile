FROM openjdk:8u191-jre-alpine3.8

RUN apk add curl jq

#Wokrspace
WORKDIR /usr/tamaldatta/leasingMarktAutomation

# Add .jar under target from host into this image
ADD target/LeasingMarktBasicTestPOC-1.0-SNAPSHOT.jar            LeasingMarktBasicTestPOC-1.0-SNAPSHOT.jar
ADD target/LeasingMarktBasicTestPOC-1.0-SNAPSHOT-tests.jar       LeasingMarktBasicTestPOC-1.0-SNAPSHOT-tests.jar
# Add libs files too and other dependeny files .csv, /.json /.xls

# ADD Suite files
ADD leasingMarkttestNG.xml      leasingMarkttestNG.xml

# ADD Heath Check script

ADD healthcheck.sh   healthcheck.sh

# Browser
# hub host
# testNG Suite
ENTRYPOINT sh healthcheck.sh

