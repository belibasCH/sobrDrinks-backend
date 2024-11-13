package com.example.sobrdrinks.example;

import com.pi4j.Pi4J;
import com.pi4j.context.Context;
import com.pi4j.io.gpio.digital.DigitalOutput;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    @GetMapping("/")
    public String hello() {
        return "Der Server ist gestartet! - v3";
    }
    @GetMapping("/lightsOn")
    public String lightsOn() throws InterruptedException {

        // Create a new Pi4J context
        Context pi4j = Pi4J.newAutoContext();

        // Configure and provision the digital output using the Raspberry Pi provider
        DigitalOutput ledPin = pi4j.dout().create(17);

        // Use the pin as before
        ledPin.high();
        Thread.sleep(2000);
        ledPin.low();

        pi4j.shutdown();
        return "Licht ausgeschaltet!";
    }
}

