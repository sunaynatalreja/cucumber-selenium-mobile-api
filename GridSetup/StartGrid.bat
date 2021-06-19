ECHO Running a batch file..
:: Below is the batch filename without double quotes.
start cmd /k Hub.bat
timeout /t 5 /nobreak
:: Below is the batch filename without double quotes.
start cmd /k Node-edge.bat
timeout /t 5 /nobreak
:: Below is the batch filename without double quotes.
start cmd /k Node-firefox.bat
timeout /t 5 /nobreak
:: Below is the batch filename without double quotes.
start cmd /k Node-ie.bat
timeout /t 5 /nobreak
:: Below is the batch filename without double quotes.
start cmd /k Node-chrome.bat
timeout /t 5 /nobreak
:: Below is the batch filename without double quotes.
start cmd /k AppiumServer.bat
timeout /t 5 /nobreak
