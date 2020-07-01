Instruktionen zur Ausführung des Chat-Systems
---------------------------------------------

1. Registry starten 

Windows: 
startregistry

Linux/Mac:
./startregistry.sh (allenfalls das Skript noch ausführbar machen mit chmod +x)

2. Server starten 

java -cp bin ChatServer oder einfach mit dem Skript chatserver


3. Client starten 

java -cp bin ChatClient localhost oder <remote ip> oder einfach mit dem Skript client localhost

- Eingabe eines Namens und Login drücken.
- Eingabe eines Posts bzw. Textes und Return drücken.
- Logut drücken, um sich abzumelden. 

Achtung: Bei mehreren Netzwerkkarten im Notebook muss evtl. explizit die IP-Adresse der Karte bzw. Adapter (WLAN) mit der Puplic-IP angegeben werden (Fehler: connection refused). 

java –cp bin –Djava.rmi.server.hostname=<ip address> ChatServer oder ChatClient <remote ip> 


