package org.example.utils;

import org.example.core.Template;
import spark.Request;
import spark.Response;

import java.util.HashMap;

public class TestController {

    public String detail(Request req, Response res) {
        return Template.render("test.html", new HashMap<>());
    }
}
