Client/Server-Beispiel mit Sockets
----------------------------------

1. Server starten mit: java -cp bin EchoServer 50000 oder einfach mit dem Skript server 50000 
   (Abbruch mit Ctrl + C)

2. Client starten mit: java -cp bin EchoClient localhost 50000 Hallo oder einfach mit dem Skript 
   client localhost 50000 <meldung> (für die Ausführung auf demselben Rechner, wo der Server läuft) 

Für den Aufruf des Servers auf einem anderen Rechner, muss localhost durch die IP-Adresse des 
andern Rechners ersetzt werden.