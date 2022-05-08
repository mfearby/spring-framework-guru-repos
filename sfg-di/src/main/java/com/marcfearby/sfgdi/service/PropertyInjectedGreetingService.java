package com.marcfearby.sfgdi.service;

import org.springframework.stereotype.Service;

// Adding this after refactoring GreetingServiceImpl -> ConstructorGreetingService
// caused the following error: Parameter 0 of constructor in ...ConstructorInjectedController
//                             required a single bean, but 2 were found: [etc]
// Consider marking one of the beans as @Primary, updating the consumer to accept multiple beans,
// or using @Qualifier to identify the bean that should be consumed
@Service
public class PropertyInjectedGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Hello world - property";
    }

}
