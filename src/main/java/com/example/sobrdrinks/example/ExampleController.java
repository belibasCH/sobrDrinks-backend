package com.example.sobrdrinks.example;

import com.pi4j.io.gpio.*;
import com.pi4j.wiringpi.Gpio;
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
        final GpioController gpio = GpioFactory.getInstance();

        // Konfiguriere den GPIO-Pin als digitalen Ausgang (z. B. GPIO 17)
        final GpioPinDigitalOutput ledPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "LED", PinState.LOW);

        // LED einschalten
        ledPin.high();
        System.out.println("LED an");

        // Warten
        Thread.sleep(2000);

        // LED ausschalten
        ledPin.low();
        System.out.println("LED aus");

        // GPIO beenden und Ressourcen freigeben
        gpio.shutdown();

        return "Licht ausgeschaltet!";
    }
}

