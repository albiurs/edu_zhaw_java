Registry starten:
Windows:
set CLASSPATH=bin
rmiregistry

Mac/Linux:
export CLASSPATH=bin
rmiregistry -J-Djava.rmi.server.logCalls=true


Server starten:
java -cp bin BMIserver

Client starten:
java -cp bin BMIclient localhost <mass[kg]> <height[m]>

