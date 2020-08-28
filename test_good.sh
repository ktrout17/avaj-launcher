#!/usr/bin/bash

for file in ./good_test_scenarios/*.txt
do
    if java avaj.simulator.Simulator $file && [ -e simulation.txt ]; then
        echo "avaj.Simulator.Simulator " $file
	    echo "OK!"
        rm -rf simulation.txt
    else
        echo "avaj.Simulator.Simulator " $file
        echo "INCORRECT! Press enter to continue."
        read _
    fi
done