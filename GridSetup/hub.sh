#!/bin/bash
GRID_VERSION=4.24.0
SELENIUM_JAR="selenium-server-$GRID_VERSION.jar"
DOWNLOAD_URL="https://github.com/SeleniumHQ/selenium/releases/download/selenium-$GRID_VERSION/$SELENIUM_JAR"

echo "Starting Selenium Grid Hub ($GRID_VERSION)"
if [ ! -f "$SELENIUM_JAR" ]; then
  echo "Downloading $SELENIUM_JAR ..."
  curl -L -o "$SELENIUM_JAR" "$DOWNLOAD_URL"
fi
java -jar "$SELENIUM_JAR" hub --port 4444 &
echo "Hub started → http://localhost:4444/ui"
