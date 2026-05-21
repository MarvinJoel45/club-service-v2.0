#!/bin/bash

cd /home/ubuntu/club-service

echo "Starting application..."

JAR_NAME=$(ls target/*.jar | head -n 1)

nohup java -XX:MaxRAMPercentage=95 -jar $JAR_NAME > app.log 2>&1 &