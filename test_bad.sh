#!/usr/bin/bash

RED='\e[31m'
GREEN='\e[32m'
BLUE='\e[34m'
RC='\033[0m' # Reset color

echo -e "${BLUE}Script will return ${RC}${GREEN}OK!${RC}${BLUE} if there are Exceptions as these are all bad tests.\nPress enter to continue${RC}"
read _

for file in ./bad_test_scenarios/*.txt
do
	if java avaj.simulator.Simulator $file; then
		echo -e "${RED}avaj.Simulator.Simulator " $file
		echo -e "KO!${RC} Press enter to continue."
		read _
	else
		echo -e "${GREEN}avaj.Simulator.Simulator " $file
		echo -e "OK!${RC}\n"
	fi
done