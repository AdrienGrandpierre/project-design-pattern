package org.example;

import org.example.core.Template;
import org.example.models.HomeSystem;
import org.example.models.Light;
import org.example.models.Thing;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThingController {
    public String detail(Request req, Response res) {

        // FIXME Protect request param for invalid values
        String idParam = req.params(":id");
        int id = Integer.parseInt(idParam);
        int index = id - 1;

        List<Thing> things = HomeSystem.getInstance().getThingsList();
        Thing thing = things.get(index);
        Light light = (Light) thing;

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
