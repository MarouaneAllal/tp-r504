#!/bin/bash

DOCKER_CONTAINER_NAME="mysqlsss"
MYSQL_USER="root"
MYSQL_PASSWORD="root"
MYSQL_DATABASE="BDD_INFO"

# Se connecter au conteneur Docker
docker exec -it "$DOCKER_CONTAINER_NAME" bash -c "mysql -u$MYSQL_USER -p'$MYSQL_PASSWORD' --local-infile=1 $MYSQL_DATABASE

-- 1. Liste de toutes les machines de marque HP
SELECT * FROM Machines WHERE marque = 'HP';


