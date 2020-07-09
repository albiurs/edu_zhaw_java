@echo off
rem create key pair
keytool -genkeypair -keyAlg RSA -dname "CN=demo" ^
-ext san=dns:localhost,ip:127.0.0.1,ip:192.168.1.142 ^
-alias demo -validity 90 -keystore keystore.jks -keypass secret -storepass secret

rem export certifacte
keytool -exportcert -alias demo -keystore keystore.jks -file server.cer -storepass secret

rem store certificate in truststore
keytool -importcert -noprompt -alias demo -file server.cer -keystore certs.jks -storepass secret
