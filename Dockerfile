FROM bellsoft/liberica-openjdk-alpine:17.0.9

# Install curl & jq which are used to hit grid-status-check endpoint
RUN apk add curl jq

# Workspace
WORKDIR /home/selenium-docker

# Add required files
ADD target/docker-resources     ./
ADD healthcheck.sh              healthcheck.sh

# Run the first command once the container starts
ENTRYPOINT sh healthcheck.sh