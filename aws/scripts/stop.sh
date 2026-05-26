#!/bin/bash

APP_DIR=/home/ubuntu/club-service
PID_FILE=$APP_DIR/app.pid

echo "Stopping application..."

if [ -f "$PID_FILE" ]; then
    PID=$(cat $PID_FILE)

    if ps -p $PID > /dev/null; then
        kill $PID
    fi

    rm -f $PID_FILE
fi

pkill -f "club-service-v1.0.0.jar" || true

echo "Application stopped"