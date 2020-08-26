package avaj.simulator.aircraft;

import avaj.weather.Coordinates;

public class AircraftFactory {
    
    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {

        Coordinates coordinates = new Coordinates(longitude, latitude, height);

        if (type.toLowerCase().equals("baloon")) {
            System.out.println(type + " " + name + " has been created.");
            return new Baloon(name, coordinates);
        }
        else if (type.toLowerCase().equals("helicopter")) {
            System.out.println(type + " " + name + " has been created.");
            return new Helicopter(name, coordinates);
        }
        else if (type.toLowerCase().equals("jetplane")) {
            System.out.println(type + " " + name + " has been created.");
            return new JetPlane(name, coordinates);
        }
        return null;
    }
}