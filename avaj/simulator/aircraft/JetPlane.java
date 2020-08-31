package avaj.simulator.aircraft;

import java.util.HashMap;

import avaj.simulator.Logger;
import avaj.simulator.WeatherTower;
import avaj.weather.Coordinates;

public class JetPlane extends Aircraft implements Flyable {
    
    private WeatherTower tower;

    JetPlane(String name, Coordinates coordinates) {
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
            put("SUN", "I can't stand this heat, time to turn on the AC.");
            put("RAIN", "I hate the rain, there better be no lightning.");
            put("FOG", "So much fog, I can't see a thing!");
            put("SNOW", "Ah snow! Please don't cause me to crash.");
        }};

        if (weather.equals("SUN")) 
            this.coordinates = new Coordinates(
                coordinates.getLongitude() + 0,
                coordinates.getLatitude() + 10,
                coordinates.getHeight() + 2
            );
        else if (weather.equals("RAIN"))
            this.coordinates = new Coordinates(
                coordinates.getLongitude() + 0,
                coordinates.getLatitude() + 5,
                coordinates.getHeight() + 0
        );
        else if (weather.equals("FOG"))
            this.coordinates = new Coordinates(
                coordinates.getLongitude() + 0,
                coordinates.getLatitude() + 1,
                coordinates.getHeight() + 0
        );
        else if (weather.equals("SNOW"))
            this.coordinates = new Coordinates(
                coordinates.getLongitude() + 0,
                coordinates.getLatitude() + 0,
                coordinates.getHeight() - 7
        );

        Logger.log("JetPlane#" + this.name + "(" + this.id + "): " + message.get(weather));
        if (this.coordinates.getHeight() <= 0) {
            Logger.log("JetPlane#" + this.name + "(" + this.id + ") landing.");
            this.tower.unregister(this);
            Logger.log("Tower says: JetPlane#" + this.name + "(" + this.id + ") unregistered from weather tower.");
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.tower = weatherTower;
        this.tower.register(this);
        Logger.log("Tower says: JetPlane#" + this.name + "(" + this.id + ") registered to weather tower.");
    }
}