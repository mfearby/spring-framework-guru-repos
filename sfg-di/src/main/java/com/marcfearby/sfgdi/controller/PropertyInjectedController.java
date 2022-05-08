package com.marcfearby.sfgdi.controller;

import com.marcfearby.sfgdi.service.GreetingService;

public class PropertyInjectedController {

    public GreetingService greetingService;

    public String getGreeting() {
        return greetingService.sayGreeting();
    }

}
