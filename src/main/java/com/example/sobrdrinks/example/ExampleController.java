package com.example.sobrdrinks.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    @GetMapping("/")
    public String hello() {
        return "Der Server ist gestartet!";}

    @GetMapping("/lightsOn")
    public String lightsOn() {
        return "Lights on! v2";
    }

}
