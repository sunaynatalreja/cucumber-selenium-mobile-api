SET HUBHOST=localhost
SET NODEHOST=localhost
IF NOT [%1] == [] SET HUBHOST=%1
IF NOT [%1] == [] SET NODEHOST=%1
start java -Dwebdriver.edge.driver=msedgedriver.exe -jar selenium-server-standalone-3.141.59.jar -role webdriver -hub http://%HUBHOST%:4444/grid/register -hubHost %HUBHOST% -host %NODEHOST% -port 5559 -browser  "browserName=MicrosoftEdge, version=ANY, maxInstances=10, platform=WINDOWS" 
Exit
