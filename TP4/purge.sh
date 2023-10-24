#!/bin/bash
docker stop $(docker ps -q) && docker rm -f $(docker ps -aq)
docker system prune -a -f
docker network prune -f
docker volume prune -f
