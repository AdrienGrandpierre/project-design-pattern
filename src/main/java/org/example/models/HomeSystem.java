package org.example.models;

import org.example.models.Thing;

import java.util.ArrayList;
import java.util.List;

public class HomeSystem implements Light.OnLightChangedListener {

    private final List<Thing> thingsList;

    private static HomeSystem INSTANCE;
    private final List<String> logs = new ArrayList<>();

    public static HomeSystem getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new HomeSystem();
        }
        return INSTANCE;
    }

    private HomeSystem() {
        this.thingsList = new ArrayList<>();
    }

    public List<Thing> getThingsList() {
        return thingsList;
    }

    public boolean addThings(Thing t) {
        return this.thingsList.add(t);
    }

    @Override
    public void onLightChanged(Light light) {
        String message = "HomeSystem - Light " + light.getName() + " updated. light on = " + light.isLightOn();
        System.out.println(message);
        logs.add(message);
    }
}
