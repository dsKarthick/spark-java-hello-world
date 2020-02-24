package com.atlassian.teams;

import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Spark;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.get;

public class HelloWorld {

    public static void main(String[] args) {
        Spark.staticFiles.location("templates");
        get("/", "application/html", HelloWorld::handleIndex, new VelocityTemplateEngine());
        get("/hello", "application/html", HelloWorld::handleHello, new VelocityTemplateEngine());
    }

    public static ModelAndView handleHello(Request req, Response res) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", "Karthick");
        return new ModelAndView(params, "hello.html");
    }

    public static ModelAndView handleIndex(Request req, Response res) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", "Karthick");
        return new ModelAndView(params, "index.html");
    }
}
