#!/bin/bash


# Do not start the tests immediately. Hub has to be ready with browser nodes
echo "Checking if hub is ready..!"
count=0
while [ "$( curl -s http://"${HUB_HOST}":4444/status | jq -r .value.ready )" != "true" ]
do
  count=$((count+1))
  echo "Attempt: ${count}"
  sleep 1
done

echo "Selenium Grid is up and running. Continuing..."

# Start the java command
java -cp 'libs/*' \
     -Dselenium.grid.enabled=true \
     -Dselenium.grid.hubHost="${HUB_HOST}" \
     -Dbrowser="${BROWSER}" \
     org.testng.TestNG \
     suites/"${TEST_SUITE}"