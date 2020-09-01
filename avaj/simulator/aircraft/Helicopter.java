package avaj.simulator.aircraft;

import java.util.HashMap;

import avaj.simulator.Logger;
import avaj.simulator.WeatherTower;
import avaj.weather.Coordinates;

public class Helicopter extends Aircraft implements Flyable {
    
    private WeatherTower tower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = tower.getWeather(this.coordinates);
        HashMap<String, String> message = new HashMap<String, String>() {
            /**
            *
            */
            private static final long serialVersionUID = 1L;

            {
            put("SUN", "It's so hot, wish I had installed that AC.");
            put("RAIN", "Ah rain my old friend, at least I fixed the wipers.");
            put("FOG", "So much fog, I can't see a thing! Radar, don't give in now.");
            put("SNOW", "Oh no, not the snow! I hope my rotor doesn't freeze.");
        }};

        if (weather.equals("SUN")) 
            this.coordinates = new Coordinates(
                coordinates.getLongitude() + 10,
                coordinates.getLatitude() + 0,
                coordinates.getHeight() + 2
            );
        else if (weather.equals("RAIN"))
            this.coordinates = new Coordinates(
                coordinates.getLongitude() + 5,
                coordinates.getLatitude() + 0,
                coordinates.getHeight() + 0
        );
        else if (weather.equals("FOG"))
            this.coordinates = new Coordinates(
                coordinates.getLongitude() + 1,
                coordinates.getLatitude() + 0,
                coordinates.getHeight() + 0
        );
        else if (weather.equals("SNOW"))
            this.coordinates = new Coordinates(
                coordinates.getLongitude() + 0,
                coordinates.getLatitude() + 0,
                coordinates.getHeight() - 12
        );

        Logger.log("Helicopter#" + this.name + "(" + this.id + "): " + message.get(weather));
        if (this.coordinates.getHeight() <= 0) {
            Logger.log("Helicopter#" + this.name + "(" + this.id + ") landing.");
            Logger.log("Current coordinates: Longitude [" + this.coordinates.getLongitude() + "] Latitude [" + this.coordinates.getLatitude() + "] Height [" + this.coordinates.getHeight() + "]");
            this.tower.unregister(this);
            Logger.log("Tower says: Helicopter#" + this.name + "(" + this.id + ") unregistered from weather tower.");
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.tower = weatherTower;
        this.tower.register(this);
        Logger.log("Tower says: Helicopter#" + this.name + "(" + this.id + ") registered to weather tower.");
    }
}