package org.example;

import org.example.models.Thing;

import java.util.ArrayList;
import java.util.List;

public class HomeSystem{

    private final List<Thing> thingsList;

    public HomeSystem() {
        this.thingsList = new ArrayList<>();
    }

    public List<Thing> getThingsList() {
        return thingsList;
    }

    public boolean addThings(Thing t) {
        return this.thingsList.add(t);
    }

}
