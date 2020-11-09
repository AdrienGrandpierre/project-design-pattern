package org.example;

import org.example.core.Template;
import org.example.models.Light;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

public class HomeSytemController {

    public String list(Request req, Response res){

        HomeSystem homeSystem = new HomeSystem();

        Light lightLivingRoom = new Light();
        lightLivingRoom.setName("Living room");
        homeSystem.addThings(lightLivingRoom);

        Light lightKitchen = new Light();
        lightKitchen.setName("Kitchen");
        homeSystem.addThings(lightKitchen);

        Map<String, Object> model = new HashMap<>();
        model.put("things", homeSystem.getThingsList());
        return Template.render("home.html",model);
    }
}
