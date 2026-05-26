#!/bin/bash

JAR_NAME=club-service-v1.0.0.jar
PID_FILE=/var/run/club-service/app.pid

echo "Stopping application..."

if [ -f "$PID_FILE" ]; then
    PID=$(cat $PID_FILE)

    if ps -p $PID > /dev/null; then
        kill $PID
    fi

    rm -f "$PID_FILE"
fi

pkill -f "$JAR_NAME" || true

echo "Application stopped"