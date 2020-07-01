#!/bin/sh
echo Shutdown registry by pressing Ctrl + C
export CLASSPATH=bin
rmiregistry -J-Djava.rmi.server.logCalls=true

