#!/bin/bash

APP_DIR=/home/ubuntu/club-service

cd $APP_DIR

echo "Stopping application..."

if [ -f "app.pid" ]; then
    PID=$(cat app.pid)

    if ps -p $PID > /dev/null; then
        kill $PID
    fi

    rm -f app.pid
fi

pkill -f "club-service-v1.0.0.jar" || true

echo "Application stopped"