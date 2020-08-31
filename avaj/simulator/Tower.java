package avaj.simulator;

import avaj.simulator.aircraft.Flyable;

import java.util.ArrayList;
import java.util.List;

// Observes when aircrafts register and deregister from tower

public class Tower {
    
    private List<Flyable> observers = new ArrayList<>();
    private List<Flyable> unregistered = new ArrayList<>();


    public void register (Flyable flyable) {

        if (!observers.contains(flyable))
            observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        
        if (!unregistered.contains(flyable))
            unregistered.add(flyable);
    }

    protected void conditionChanged() {

        for (Flyable flyable : observers) {
            flyable.updateConditions();
        }
        observers.removeAll(unregistered);
    }
}