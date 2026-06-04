#!/bin/bash

set -euo pipefail

sudo mkdir -p /etc/club-service

DATABASE_HOST=$(aws ssm get-parameter \
  --name "/club-service/prod/database/host" \
  --query "Parameter.Value" \
  --output text)

DATABASE_PORT=$(aws ssm get-parameter \
  --name "/club-service/prod/database/port" \
  --query "Parameter.Value" \
  --output text)

DATABASE_NAME=$(aws ssm get-parameter \
  --name "/club-service/prod/database/name" \
  --query "Parameter.Value" \
  --output text)

DATABASE_USER=$(aws ssm get-parameter \
  --name "/club-service/prod/database/user" \
  --with-decryption \
  --query "Parameter.Value" \
  --output text)

DATABASE_PASSWORD=$(aws ssm get-parameter \
  --name "/club-service/prod/database/password" \
  --with-decryption \
  --query "Parameter.Value" \
  --output text)

sudo tee /etc/club-service/env > /dev/null <<EOF
DATABASE_HOST=${DATABASE_HOST}
DATABASE_PORT=${DATABASE_PORT}
DATABASE_NAME=${DATABASE_NAME}
DATABASE_USER=${DATABASE_USER}
DATABASE_PASSWORD=${DATABASE_PASSWORD}
EOF

sudo chmod 600 /etc/club-service/env
sudo chown root:root /etc/club-service/env