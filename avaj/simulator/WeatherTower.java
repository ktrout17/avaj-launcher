package avaj.simulator;

import avaj.weather.*;

// Handles coords

public class WeatherTower extends Tower {
    
    public String getWeather(Coordinates coordinates) {
        
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    void changeWeather() {

        this.conditionChanged();
    }
}