@echo off
SETLOCAL
SET GRID_VERSION=4.24.0
SET SELENIUM_JAR=selenium-server-%GRID_VERSION%.jar
SET DOWNLOAD_URL=https://github.com/SeleniumHQ/selenium/releases/download/selenium-%GRID_VERSION%/%SELENIUM_JAR%
SET PORT=4444

echo Starting Selenium Grid %GRID_VERSION% (Standalone Mode)
IF NOT EXIST %SELENIUM_JAR% (
    echo Downloading %SELENIUM_JAR%...
    powershell -Command "Invoke-WebRequest -Uri '%DOWNLOAD_URL%' -OutFile '%SELENIUM_JAR%'"
)
start java -jar %SELENIUM_JAR% standalone --detect-drivers true --port %PORT%
echo Grid started → http://localhost:%PORT%/ui
ENDLOCAL
exit
