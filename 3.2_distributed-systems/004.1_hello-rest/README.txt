Instruktionen
-------------

Aufruf Webserver:
Server:
MacOS/Linux: java --add-opens java.base/java.lang=ALL-UNNAMED -cp "bin:lib/*" Server
Windows: java -cp "bin;lib/*"
oder einfach mit dem Skript server (Windows) bzw. ./server.sh (MacOS, Linux)

Beispiel-Aufrufe mit cURL:
curl -i http://localhost:50000/api/hello
curl -i -H "Accept: text/plain" http://localhost:50000/api/hello
curl -i -H "Accept: application/json" http://localhost:50000/api/hello

