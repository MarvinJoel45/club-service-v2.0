#!/bin/bash

cd /home/ubuntu/club-service

echo "Building application..."

sudo mvn clean package -DskipTests