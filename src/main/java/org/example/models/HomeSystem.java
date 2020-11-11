package org.example.models;

import org.example.SystemLogger;
import org.example.models.Thing;

import java.util.ArrayList;
import java.util.List;

public class HomeSystem implements Light.OnLightChangedListener {

    public enum State{
        ON,
        OFF,
    }
    private final List<Thing> thingsList;
private final SystemLogger logger;
    private State state;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public HomeSystem(SystemLogger logger) {
        this.logger = logger;
        this.thingsList = new ArrayList<>();
        this.state = State.ON;
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
        logger.addLog(message);
    }

    public void toggleAllLights(boolean isLightOn) {
        if (this.state == State.OFF){
            return;
        }

        for (Light l : getLights()){
            l.setLightOn(isLightOn);
        }
    }

    public List<Light> getLights(){
        List<Light> list = new ArrayList<>();

        for (Thing t : thingsList){
            if (t instanceof  Light){
                list.add((Light) t);
            }
        }
        return list;
    }
}
