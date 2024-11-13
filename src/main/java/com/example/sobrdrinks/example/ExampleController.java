package com.example.sobrdrinks.example;

import com.pi4j.Pi4J;
import com.pi4j.context.Context;
import com.pi4j.io.gpio.*;
import com.pi4j.io.gpio.digital.DigitalOutput;
import com.pi4j.io.gpio.digital.DigitalOutputConfig;
import com.pi4j.io.gpio.digital.DigitalState;
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
        // Initialize Pi4J context
        Context pi4j = Pi4J.newAutoContext();

        // Configure the GPIO pin (e.g., GPIO 17)
        DigitalOutputConfig outputConfig = DigitalOutput.newConfigBuilder(pi4j)
                .id("LED")
                .name("LED")
                .address(18) // Use the BCM numbering
                .shutdown(DigitalState.LOW)
                .initial(DigitalState.LOW)
                .build();

        // Provision the digital output
        DigitalOutput ledPin = pi4j.create(outputConfig);

        // Turn the LED on
        ledPin.high();
        System.out.println("LED an");

        // Wait
        Thread.sleep(2000);

        // Turn the LED off
        ledPin.low();
        System.out.println("LED aus");

        // Shutdown Pi4J context
        pi4j.shutdown();

        return "Licht ausgeschaltet!";
    }
}

