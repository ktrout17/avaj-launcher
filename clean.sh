#!/bin/sh

YELLOW='\e[33m'

find . -name *.class -delete
rm sources.txt
rm simulation.txt
echo "${YELLOW}Cleanup complete"