@echo off
rem list keystore
keytool -v -list -keystore "bin/keystore.jks" -keypass secret -storepass secret
