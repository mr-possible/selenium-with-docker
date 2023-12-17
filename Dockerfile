FROM bellsoft/liberica-openjdk-alpine:17.0.9

# Workspace
WORKDIR /home/selenium-docker

# Add required files
ADD target/docker-resources ./

# Environment Variables
# HUB_HOST
# BROWSER
# TEST_SUITE

# Run the first command once the container starts
ENTRYPOINT java -cp "libs/*" \
           -Dbrowser=${BROWSER} -Dselenium.grid.hubHost=${HUB_HOST} \
           org.testng.TestNG suites/${TEST_SUITE}

