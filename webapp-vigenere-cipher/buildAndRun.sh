#!/bin/sh
mvn clean package && docker build -t pl.polsl/webapp-vigenere-cipher .
docker rm -f webapp-vigenere-cipher || true && docker run -d -p 9080:9080 -p 9443:9443 --name webapp-vigenere-cipher pl.polsl/webapp-vigenere-cipher