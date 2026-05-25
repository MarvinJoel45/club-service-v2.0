#!/bin/bash
set -e

APP_DIR=/home/ubuntu/club-service
JAR_NAME=club-service-v1.0.0.jar

cd $APP_DIR

echo "Starting application..."

source /etc/environment

pkill -f "$JAR_NAME" || true

nohup java \
  -XX:MaxRAMPercentage=95 \
  -jar $JAR_NAME \
  > app.log 2>&1 &

echo $! > app.pid

echo "Application started"