package avaj.simulator.aircraft;

import java.util.HashMap;

import avaj.weather.Coordinates;
import avaj.simulator.WeatherTower;
import avaj.simulator.Logger;

public class Baloon extends Aircraft implements Flyable {

    private WeatherTower tower;

    Baloon(String name, Coordinates coordinates) {
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
            put("SUN", "It's so hot, I’m sweating in spots I didn’t know I had.");
            put("RAIN", "Rain, rain, go away! Please come back another day!");
            put("FOG", "So much fog, I can't see a thing! Should've invested in those fog lights..");
            put("SNOW", "Oh no, not the snow! I am not prepared for this.");
        }};

        if (weather.equals("SUN")) 
            this.coordinates = new Coordinates(
                coordinates.getLongitude() + 2,
                coordinates.getLatitude() + 0,
                coordinates.getHeight() + 4
            );
        else if (weather.equals("RAIN"))
            this.coordinates = new Coordinates(
                coordinates.getLongitude() + 0,
                coordinates.getLatitude() + 0,
                coordinates.getHeight() - 5
        );
        else if (weather.equals("FOG"))
            this.coordinates = new Coordinates(
                coordinates.getLongitude() + 0,
                coordinates.getLatitude() + 0,
                coordinates.getHeight() - 3
        );
        else if (weather.equals("SNOW"))
            this.coordinates = new Coordinates(
                coordinates.getLongitude() + 0,
                coordinates.getLatitude() + 0,
                coordinates.getHeight() - 15
        );

        Logger.log("Baloon#" + this.name + "(" + this.id + "): " + message.get(weather));
        if (this.coordinates.getHeight() <= 0) {
            Logger.log("Baloon#" + this.name + "(" + this.id + ") landing.");
            this.tower.unregister(this);
            Logger.log("Tower says: Baloon#" + this.name + "(" + this.id + ") unregistered from weather tower.");
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.tower = weatherTower;
        this.tower.register(this);
        Logger.log("Tower says: Baloon#" + this.name + "(" + this.id + ") registered to weather tower.");
    }
}