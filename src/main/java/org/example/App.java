package org.example;

import org.example.core.Conf;
import org.example.core.Template;
import org.example.middlewares.LoggerMiddleware;
import org.example.models.HomeSystem;
import org.example.models.Light;
import spark.Spark;

public class App {


    public static void main(String[] args) {
        initialize();

        HomeSystem homeSystem = HomeSystem.getInstance();
        Light light = new Light();
        light.setName("Living room");
        light.setLightChangedListener(homeSystem);
        homeSystem.addThings(light);

        light = new Light();
        light.setName("Kitchen");
        light.setLightChangedListener(homeSystem);
        homeSystem.addThings(light);

        HomeSytemController homeSytemController = new HomeSytemController();
        ThingController thingController = new ThingController();

        Spark.get("/", (req, res) -> homeSytemController.list(req, res));
        Spark.get("/things/:id", (req, res) -> thingController.detail(req, res));

//        Spark.get("/", (req, res) -> {
//            return Template.render("home.html", new HashMap<>());
//        });
    }

    static void initialize() {
        Template.initialize();

        // Display exceptions in logs
        Spark.exception(Exception.class, (e, req, res) -> e.printStackTrace());

        // Serve static files (img/css/js)
        Spark.staticFiles.externalLocation(Conf.STATIC_DIR.getPath());

        // Configure server port
        Spark.port(Conf.HTTP_PORT);
        final LoggerMiddleware log = new LoggerMiddleware();
        Spark.before(log::process);
    }
}
