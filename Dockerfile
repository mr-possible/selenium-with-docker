FROM openjdk:8-jre-alpine

# Install utilities that you want.
RUN apk add curl jq

# Workspace
WORKDIR /usr/share/sambhav_work

# Add .jars under target location from host into this image
ADD target/selenium-docker.jar /usr/share/sambhav_work/selenium-docker.jar
ADD target/selenium-docker-tests.jar /usr/share/sambhav_work/selenium-docker-tests.jar
ADD target/libs /usr/share/sambhav_work/libs

# In case of any other dependency like .csv/.json/.xls => please add that here as well
# Add suite files
ADD test-suite.xml /usr/share/sambhav_work/testng-suite.xml

# Add your healthcheck script
ADD healthcheck.sh /usr/share/sambhav_work/healthcheck.sh

# Expecting browser, hub-host, and module to run.
ENTRYPOINT sh healthcheck.sh