Instruktionen zur Ausf�hrung des Chat-Systems
---------------------------------------------

1. Registry starten 

Windows: 
startregistry

Linux/Mac:
./startregistry.sh (allenfalls das Skript noch ausf�hrbar machen mit chmod +x)

2. Server starten 

java -cp bin ChatServer oder einfach mit dem Skript chatserver


3. Client starten 

java -cp bin ChatClient localhost oder <remote ip> oder einfach mit dem Skript client localhost

- Eingabe eines Namens und Login dr�cken.
- Eingabe eines Posts bzw. Textes und Return dr�cken.
- Logut dr�cken, um sich abzumelden. 

Achtung: Bei mehreren Netzwerkkarten im Notebook muss evtl. explizit die IP-Adresse der Karte bzw. Adapter (WLAN) mit der Puplic-IP angegeben werden (Fehler: connection refused). 

java �cp bin �Djava.rmi.server.hostname=<ip address> ChatServer oder ChatClient <remote ip> 


