package avaj.simulator.aircraft;

import avaj.weather.Coordinates;

import java.util.HashMap;

import avaj.simulator.WeatherTower;

public class Baloon extends Aircraft implements Flyable {
    
    private WeatherTower tower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = tower.getWeather(this.coordinates);
        HashMap<String, String> message = new HashMap<String, String>() {{
            put("SUN", "It's so hot, I’m sweating in spots I didn’t know I had.");
            put("RAIN", "Rain, rain, go away! Please come back another day!");
            put("FOG", "So much fog, I can't see a thing! Should've invested in those fog lights..");
            put("SNOW", "Oh no, not the snow! I not prepared for this.");
            put("GROUNDED", "Oh no, we're about to be gounded. Please no crash, please no crash!");
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

    }
}