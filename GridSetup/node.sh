#!/bin/bash
GRID_VERSION=4.24.0
SELENIUM_JAR="selenium-server-$GRID_VERSION.jar"
DOWNLOAD_URL="https://github.com/SeleniumHQ/selenium/releases/download/selenium-$GRID_VERSION/$SELENIUM_JAR"
HUBHOST="localhost"
NODEPORT=5556

echo "Registering Node to Hub at $HUBHOST"
if [ ! -f "$SELENIUM_JAR" ]; then
  echo "Downloading $SELENIUM_JAR ..."
  curl -L -o "$SELENIUM_JAR" "$DOWNLOAD_URL"
fi

java -jar "$SELENIUM_JAR" node \
  --detect-drivers true \
  --max-sessions 5 \
  --publish-events tcp://$HUBHOST:4442 \
  --subscribe-events tcp://$HUBHOST:4443 \
  --port $NODEPORT &
echo "Node started on port $NODEPORT"
