package avaj.simulator;

import avaj.simulator.aircraft.Flyable;

import java.util.ArrayList;
import java.util.List;

// Observes when aircrafts register and deregister from tower

public class Tower {
    
    private List<Flyable> observers = new ArrayList<>();

    public void register (Flyable flyable) {

        if (!observers.contains(flyable))
            observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        
        observers.remove(flyable);
    }

    protected void conditionChanged() {

        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).updateConditions();
        }
    }
}