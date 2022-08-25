echo Hello
echo starting 


START runcrud.bat

PING localhost -n 60  1>NUL


:chrome
START chrome http://localhost:8080/crud/v1/tasks