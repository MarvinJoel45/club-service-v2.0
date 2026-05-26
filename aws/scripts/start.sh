#!/bin/bash
set -e

APP_DIR=/home/ubuntu/club-service
JAR_NAME=club-service-v1.0.0.jar

echo "Starting application..."

source /etc/environment || true

mkdir -p $APP_DIR

touch $APP_DIR/app.log
touch $APP_DIR/app.pid

chmod 664 $APP_DIR/app.log
chmod 664 $APP_DIR/app.pid

pkill -f "$JAR_NAME" || true

nohup java \
  -XX:MaxRAMPercentage=95 \
  -jar "$APP_DIR/$JAR_NAME" \
  > "$APP_DIR/app.log" 2>&1 &

echo $! > "$APP_DIR/app.pid"

echo "Application started"