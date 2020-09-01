#!/bin/sh

GREEN='\e[32m'

find . -name *.java > sources.txt
javac -sourcepath src @sources.txt
echo "${GREEN}Compilation successful."