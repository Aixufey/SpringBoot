package com.rinseo.restfulwebservices.controller;

import com.rinseo.restfulwebservices.entity.HelloWorldBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

// REST API
@RestController
public class HelloWorldController {

    // endpoint /hello-world
    @GetMapping(path = "/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    // endpoint /hello-world-bean
    // Returning a Bean that is instance of this class with a message field
    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World");
    }


    // endpoint /hello-world/path-variable/{name}
    // /hello-world/path-variable/Rinseo
    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
        return new HelloWorldBean("Hello World ".concat(name));
    }
}
