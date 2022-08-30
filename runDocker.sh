#!/bin/bash
mvn clean install
docker build --build-arg JAR_FILE=build/libs/\*.jar
docker run -i