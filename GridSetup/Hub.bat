SET HUBHOST=localhost
IF NOT [%1] == [] SET HUBHOST=%1
start java -jar selenium-server-standalone-3.141.59.jar -role hub
Exit