Einfaches Chat-Programm mit Sockets programmiert
------------------------------------------------

Mit dem Programm Talk können zwei Benutzer an verschiedenen Rechnern eine Unterhaltung online führen. 

Hier eine kurze Anleitung.

Da das Programm für die beiden Portnummern den Standardwert 50000 eingestellt hat, kann das Programm 
vereinfacht wie folgt aufgerufen werden:

Rechner 1: java -cp bin Talk -user Hugo -remoteHost <IP Adresse> oder einfach mit dem Skript talk -user <name> -remotehost <IP Adresse>
Rechner 2: java -cp bin Talk -user Emil -remoteHost <IP Adresse> oder einfach mit dem Skript talk -user <name> -remotehost <IP Adresse>

Zum Test kann das Programm auch zweimal auf demselben Rechner (localhost)
gestartet werden. Allerdings müssen dann die Portnummern unterschiedlich sein:

talk -user Hugo -localPort 40000 -remoteHost localhost -remotePort 50000
talk -user Emil -localPort 50000 -remoteHost localhost -remotePort 40000
