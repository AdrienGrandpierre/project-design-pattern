package org.example;

import org.example.core.Template;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

public class TestController {

    public String detail(Request req, Response res) {

        Map<String, Object> model = new HashMap<>();
        return Template.render("test.html",model);

    }
}
