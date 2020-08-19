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
        String weather = WeatherTower.getWeather(this.coordinates);
    }

    private HashMap<String, String> message = new HashMap<String, String>() {

    }
}