@echo off
echo Shutdown registry by pressing Ctrl + C
set CLASSPATH=bin
rmiregistry -J-Djava.rmi.server.logCalls=true
