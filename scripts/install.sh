#!/bin/bash

set -e

sudo mkdir -p /opt/club-service

sudo chmod 755 /opt/club-service
sudo chmod 755 /opt/club-service/club-service.jar

sudo tee /etc/systemd/system/club-service.service > /dev/null <<EOF
[Unit]
Description=Club Service Spring Boot Application
After=network.target

[Service]
Type=simple
User=ubuntu
WorkingDirectory=/opt/club-service
EnvironmentFile=/etc/club-service/env
ExecStart=/usr/bin/java -jar /opt/club-service/club-service.jar
SuccessExitStatus=143
Restart=always
RestartSec=5

[Install]
WantedBy=multi-user.target
EOF

sudo systemctl daemon-reload
sudo systemctl enable club-service