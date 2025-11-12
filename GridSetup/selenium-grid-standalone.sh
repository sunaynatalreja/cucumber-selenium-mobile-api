#!/bin/bash
GRID_VERSION=4.24.0
SELENIUM_JAR="selenium-server-$GRID_VERSION.jar"
DOWNLOAD_URL="https://github.com/SeleniumHQ/selenium/releases/download/selenium-$GRID_VERSION/$SELENIUM_JAR"
PORT=4444

echo "Starting Selenium Grid $GRID_VERSION (Standalone Mode)"
if [ ! -f "$SELENIUM_JAR" ]; then
  echo "Downloading $SELENIUM_JAR ..."
  curl -L -o "$SELENIUM_JAR" "$DOWNLOAD_URL"
fi
java -jar "$SELENIUM_JAR" standalone --detect-drivers true --port $PORT &
echo "Grid started → http://localhost:$PORT/ui"
