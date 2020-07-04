Installieren von ActiveMQ
-------------------------
http://activemq.apache.org/components/classic/download/

Installation des Open Source Message-Brokers ActiveMQ (http://activemq.apache.org); ZIP-File, das auf dem Rechner
entpackt werden muss (s. Installations-Instruktionen für Windows und MacOS/Linux). Achtung: Unter Windows darf das
Verzeichnis, indem das ZIP-File entpackt wird, keine Leerstellen enthalten!)


Starten des Message Brokers (ActiveMQ)
--------------------------------------

Im Installationsverzeichnis von ActiveMQ befindet sich das Unterverzeichnis \bin.
Hier muss nun mittels Konsole (Eingabeaufforderung) der Message Broker gestartet werden.

activemq start (MacOS/Linux: ./activemq console)    

Durch Eingabe von Strg + C kann er später beendet werden.

Die Aktivitäten des Brokers sowie Nachrichtenziele (Queues, Topics) können mit Hilfe einer Web Console überwacht werden:

http://localhost:8161/admin oder http://<IP-Adresse>:8161/admin (bei Verwendung eines Message-Brokers auf einem andern Rechner)

Diese Anwendung ist geschützt mit Benutzername/Passwort: admin/admin.


Starten der Programme über Konsole
----------------------------------

Windows:
java -cp "bin;lib/*" Producer Hallo  oder einfach mit dem Skript producer.bat (Windows) bzw. ./producer.sh (MacOS/Linux)
java -cp "bin;lib/*" Consumer1 30000 oder einfach mit dem Skript consumer1.bat (Windows) bzw. ./consumer1.sh (MacOS/Linux) 
java -cp "bin;lib/*" Consumer2 30000 oder einfach mit dem Skript consumer2.bat (Windows) bzw. ./consumer2.sh (MacOS/Linux) 
java -cp "bin;lib/*" QueueInfo oder einfach mit dem Skript queueinfo.bat (Windows) bzw. ./queueinfo.sh (MacOS/Linux)

Linux/Mac:
java -cp "bin:lib/*" Producer Hallo  oder einfach mit dem Skript producer.bat (Windows) bzw. ./producer.sh (MacOS/Linux)
java -cp "bin:lib/*" Consumer1 30000 oder einfach mit dem Skript consumer1.bat (Windows) bzw. ./consumer1.sh (MacOS/Linux)
java -cp "bin:lib/*" Consumer2 30000 oder einfach mit dem Skript consumer2.bat (Windows) bzw. ./consumer2.sh (MacOS/Linux)
java -cp "bin:lib/*" QueueInfo oder einfach mit dem Skript queueinfo.bat (Windows) bzw. ./queueinfo.sh (MacOS/Linux)

Achtung: Bei Linux: „:“ anstatt „;“.