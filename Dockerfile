FROM openjdk:8-jre-alpine

# Install utilities that you want.
RUN apk add curl jq

#Workspace
WORKDIR /usr/share/sambhav_work

#Add .jars under target location from host into this image
ADD target/selenium-docker.jar          selenium-docker.jar
ADD target/selenium-docker-tests.jar    selenium-docker-tests.jar
ADD target/libs                         libs

# in case of any other dependancy like .csv/.json/.xls => please add that here as well
#Add suite files
ADD testng-suite.xml                    testng-suite.xml

# Add your healthcheck script
ADD healthcheck.sh                      healthcheck.sh

# Expecting browser , hub-host and module to run.
ENTRYPOINT sh healthcheck.sh