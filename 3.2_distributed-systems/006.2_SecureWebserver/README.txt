Instruktionen
-------------

Der aus LE03 verwendetete, einfache Webserver mit HTTP Basic Authentication und SSL/TLS für die 
sichere Datenübertragung (selbstsigniertes X.509 Zertifikat).  

1. Zertifikat erstellen:

Im Skript die IP-Addresse anpassen auf die eigene IP-Adresse. 

Aufruf des keytools: genkeystore bzw. ./genkeystore.sh

Den keystore.jks ins bin Verzeichnis des Webservers kopieren. 

2. Webserver starten:

Mit Skript mywebserver bzw. ./webserver.sh oder explizit  
java -Dcontent.types.user.table=content-types.properties -cp bin MyWebserver

3. Aufruf im Browser: 

https://localhost:50443
Authentifizierung: secret/secret

oder mit cURL

curl -v -k -u secret:secret https://localhost:50443

In Eclipse kann die Fehlermeldung "Access restriction ..." wie folgt ausgeschaltet werden:
Window > Preferences > Java > Compiler > Errors/Warnings
Unter "Deprecated and restricted API" Option "Forbidden reference (access rules)"
auf "Warning" oder "Ignore" setzen.
