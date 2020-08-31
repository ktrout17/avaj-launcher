#!/usr/bin/bash

for file in ./bad_test_scenarios/*.txt
do
	if java avaj.simulator.Simulator $file | grep -q "Error"; then
		echo "avaj.Simulator.Simulator " $file
		echo "OK!"
	else
		echo "avaj.Simulator.Simulator " $file
		echo "INCORRECT! Press enter to continue."
		read _
	fi
done