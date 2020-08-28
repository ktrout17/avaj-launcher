package avaj.simulator.aircraft;

import avaj.simulator.SimException;
import avaj.weather.Coordinates;

public class AircraftFactory {
    
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height)
            throws SimException {
        
        if (longitude < 0 || latitude < 0 || height < 0)
            throw new SimException("Error: Coordinates cannot have negative values.");
        else if (height > 100)
            height = 100;
                
        Coordinates coordinates = new Coordinates(longitude, latitude, height);

        if (type.equals("Baloon"))
            return new Baloon(name, coordinates);
        else if (type.equals("Helicopter")) 
            return new Helicopter(name, coordinates);
        else if (type.equals("JetPlane"))
            return new JetPlane(name, coordinates);
        else
            throw new SimException("Error: Unknown type [" + type + "]");
    }
}