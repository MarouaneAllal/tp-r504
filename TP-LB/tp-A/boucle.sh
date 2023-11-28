#!/bin/bash

for ((i=1; i<=500; i++)); do
  reponse=$(curl -s localhost:83)
  echo "numéro $i: $reponse"
if [[ $reponse == *"Hello 1"* ]]; then
    ((count_server1++))
  elif [[ $reponse == *"Hello 2"* ]]; then
    ((count_server2++))
  fi
  
