@echo off
call mvn clean package
call docker build -t pl.polsl/webapp-vigenere-cipher .
call docker rm -f webapp-vigenere-cipher
call docker run -d -p 9080:9080 -p 9443:9443 --name webapp-vigenere-cipher pl.polsl/webapp-vigenere-cipher