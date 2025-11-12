@echo off
SET GRID_VERSION=4.24.0
SET SELENIUM_JAR=selenium-server-%GRID_VERSION%.jar
SET HUBHOST=localhost
SET NODEPORT=5556
SET DOWNLOAD_URL=https://github.com/SeleniumHQ/selenium/releases/download/selenium-%GRID_VERSION%/%SELENIUM_JAR%
IF NOT EXIST %SELENIUM_JAR% (
    echo Downloading %SELENIUM_JAR%...
    powershell -Command "Invoke-WebRequest -Uri '%DOWNLOAD_URL%' -OutFile '%SELENIUM_JAR%'"
)
start java -jar %SELENIUM_JAR% node ^
  --detect-drivers true ^
  --max-sessions 5 ^
  --publish-events tcp://%HUBHOST%:4442 ^
  --subscribe-events tcp://%HUBHOST%:4443 ^
  --port %NODEPORT%
exit
