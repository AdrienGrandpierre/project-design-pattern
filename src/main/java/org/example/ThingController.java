package org.example;

import org.example.core.Template;
import org.example.models.HomeSystem;
import org.example.models.Light;
import org.example.models.Thermostat;
import org.example.models.Thing;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThingController {

    private final HomeSystem homeSystem;

    public ThingController(HomeSystem homeSystem) {
        this.homeSystem = homeSystem;
    }

    public String detail(Request req, Response res) {

        // FIXME Protect request param for invalid values
        String idParam = req.params(":id");
        int id = Integer.parseInt(idParam);
        int index = id - 1;

        List<Thing> things = homeSystem.getThingsList();
        Thing thing = things.get(index);

        // CODE SMELL => S'il il y a trop d'objects intelligents, ThingController va devenir un monstre
        if (thing instanceof Light) {
            return detailLight(req, res, id, (Light) thing);
        } else if (thing instanceof Thermostat) {
            return detailThermostat(req, res, id, (Thermostat) thing);
        }

        return "";
    }

    private String detailThermostat(Request req, Response res, int id, Thermostat thermostat) {

        String action = req.queryParamOrDefault("action", "");
        String value = req.queryParamOrDefault("value", "");
        String message = "";

        if (action.equals("set_temperature")) {
            int temperature = Integer.parseInt(value);
            if (!thermostat.setTemperature(temperature)) {
                message = "Desired temperature '" + temperature + "' is outside of valid range";
            }
        }

        Map<String, Object> model = new HashMap<>();
        model.put("thermostat", thermostat);
        model.put("id", id);
        model.put("message", message);
        return Template.render("thing_thermostat.html", model);
    }

    private String detailLight(Request req, Response res, int id, Light light) {
        //Handle actions
        String action = req.queryParamOrDefault("action", "");

        if (action.equals("toggle")) {
            light.setLightOn(!light.isLightOn());
            System.out.println("TOGGLED LIGHT =" + light.isLightOn());
        }

        Map<String, Object> model = new HashMap<>();
        model.put("light", light);
        model.put("id", id);
        return Template.render("thing_light.html", model);
    }
}
