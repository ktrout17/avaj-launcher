package avaj.simulator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import avaj.simulator.aircraft.AircraftFactory;
import avaj.simulator.aircraft.Flyable;

public class Simulator {
    
    public static void main(String[] args) throws SimException {

        if (args.length <= 0) {
            System.out.println("Please enter scenario file.");
            return;
        }

        try {
            Logger.setOutputFile("simulation.txt");
        } catch (IOException e) {
            System.out.println("Error opening simulation.txt");
            return;
        }

        WeatherTower tower = new WeatherTower();
        ArrayList<Flyable> flyables = new ArrayList<>();

        try {
            
            FileReader fr = new FileReader(args[0]);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            int num_of_sims;

            try {
                num_of_sims = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Error: Invalid format for simulation number.");
            }
            System.out.println(num_of_sims + " simulations will be run.");

            String current_line;

            while ((current_line = br.readLine()) != null) {
                
                String array[] = current_line.split(" ");
                if (array.length != 5)
                    throw new SimException("Error: Each line must have 5 fields.");
                try {
                    flyables.add(AircraftFactory.newAircraft(
                        array[0],
                        array[1],
                        Integer.parseInt(array[2]),
                        Integer.parseInt(array[3]),
                        Integer.parseInt(array[4])
                    ));
                } catch (NumberFormatException e) {
                    throw new SimException("Error: Expected a number.");
                }
            }
            for (Flyable flyable: flyables)
                flyable.registerTower(tower);
            for (int i = 0; i < num_of_sims; i++)
                tower.changeWeather();
            System.out.println(num_of_sims + "/" + num_of_sims + " simulations have been run.");
            System.out.println("Results have been compiled in simulation.txt.");
        } catch (IOException e) {
            System.out.println("Error with input/output.");
        }
    }
}