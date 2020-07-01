Instruktionen
-------------

Aufruf des Webservers:
MacOS: java --add-opens java.base/java.lang=ALL-UNNAMED -cp "bin:lib/*" Server
Windows: java --add-opens java.base/java.lang=ALL-UNNAMED -cp "bin;lib/*" Server
...oder einfach mit dem Skript server

Beispiel-Aufrufe mit cURL:
curl -i -H "Content-Type: text/plain" -X POST http://localhost:50000/api/messages -d "Message A"
curl -i -H "Content-Type: text/plain" -X POST http://localhost:50000/api/messages -d "Message B"
curl -i -H "Content-Type: text/plain" -X POST http://localhost:50000/api/messages -d "Message C"

curl -i http://localhost:50000/api/messages
curl -i http://localhost:50000/api/messages/1
curl -i -H "Content-Type: application/json" http://localhost:50000/api/messages

curl -i --HEAD http://localhost:50000/api/messages
curl -i --HEAD http://localhost:50000/api/messages/1

curl -i -H "Content-Type: text/plain" -X PUT http://localhost:50000/api/messages/1 -d "Message AA"
curl -i http://localhost:50000/api/messages/1

curl -i -X DELETE http://localhost:50000/api/messages/2
curl -i http://localhost:50000/api/messages

curl -i -X DELETE http://localhost:50000/api/messages
curl -i http://localhost:50000/api/messages
