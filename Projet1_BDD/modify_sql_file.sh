#!/bin/bash

echo "CREATE DATABASE sae51db;" > BDD_INFO.sql
echo "USE sae51db;" >> BDD_INFO.sql
cat fichier.sql >> BDD_INFO.sql

