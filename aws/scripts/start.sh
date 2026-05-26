#!/bin/bash
set -e

APP_DIR=/home/ubuntu/club-service
JAR_NAME=club-service-v1.0.0.jar

LOG_DIR=/var/log/club-service
RUN_DIR=/var/run/club-service

LOG_FILE=$LOG_DIR/app.log
PID_FILE=$RUN_DIR/app.pid

echo "Starting application..."

# cargar variables de entorno
source /etc/environment || true

# crear directorios runtime
sudo mkdir -p "$LOG_DIR"
sudo mkdir -p "$RUN_DIR"

# permisos
sudo chown -R ubuntu:ubuntu "$LOG_DIR"
sudo chown -R ubuntu:ubuntu "$RUN_DIR"

# ir al directorio de la app
cd "$APP_DIR"

# detener instancia previa
pkill -f "$JAR_NAME" || true

# iniciar aplicación
nohup java \
  -XX:MaxRAMPercentage=95 \
  -jar "$JAR_NAME" \
  > "$LOG_FILE" 2>&1 &

# guardar PID
echo $! > "$PID_FILE"

echo "Application started"