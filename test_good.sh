#!/usr/bin/bash

RED='\e[31m'
GREEN='\e[32m'
RC='\033[0m' # Reset color

for file in ./good_test_scenarios/*.txt
do
    if java avaj.simulator.Simulator $file && [ -e simulation.txt ]; then
        echo -e "${GREEN}avaj.Simulator.Simulator " $file
		echo -e "OK!${RC}\n"
        rm -rf simulation.txt
    else
        echo -e "${RED}avaj.Simulator.Simulator " $file
		echo -e "KO!${RC} Press enter to continue."
		read _
    fi
done