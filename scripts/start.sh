#!/bin/bash

set -e

sudo systemctl restart club-service

sleep 10

sudo systemctl status club-service --no-pager