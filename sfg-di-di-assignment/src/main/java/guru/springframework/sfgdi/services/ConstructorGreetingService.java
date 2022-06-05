package guru.springframework.sfgdi.services;

import org.springframework.stereotype.Service;

/**
 * Created by jt on 12/26/19.
 */
// The @Service was removed to demonstrate the GreetingServiceConfig,
// which shows an alternate way to setup a component (often 3rd party)
// using the @Bean annotation instead.
public class ConstructorGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello World - Constructor";
    }
}
