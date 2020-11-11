package org.example;

import org.example.core.Template;
import org.example.models.HomeSystem;
import org.example.models.Light;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

public class HomeSytemController {

    private final HomeSystem homeSystem;
    public HomeSytemController(HomeSystem homeSystem) {
        this.homeSystem = homeSystem;
    }

    public String list(Request req, Response res){

        Map<String, Object> model = new HashMap<>();
        model.put("things", homeSystem.getThingsList());
        return Template.render("home.html",model);
    }
}
