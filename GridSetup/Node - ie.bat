SET HUBHOST=localhost
SET NODEHOST=localhost
IF NOT [%1] == [] SET HUBHOST=%1
IF NOT [%1] == [] SET NODEHOST=%1
start java -Dwebdriver.ie.driver=IEDriverServer.exe -jar selenium-server-standalone-3.141.59.jar -role webdriver -hub http://%HUBHOST%:4444/grid/register -hubHost %HUBHOST% -host %NODEHOST% -port 5557 -browser "browserName=internet explorer, maxInstances=10"
Exit