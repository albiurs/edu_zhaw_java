Instruktionen
-------------

Der Monitor arbeitet als Proxy-Server und leitet die Anfrage des Browsers an den Web-Server weiter.
Aufruf:

java -cp bin Monitor bzw. Skript monitor <calling port> localhost <forwarding port> <request file name> <response file name> oder mit dem Skript monitor

Aufruf des Proxy-Monitors: java -cp bin Monitor 8080 localhost 50000 request.txt response.txt

Aufruf im Browser: http://localhost:8080/
