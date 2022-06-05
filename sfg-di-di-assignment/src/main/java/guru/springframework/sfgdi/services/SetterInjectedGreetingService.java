package guru.springframework.sfgdi.services;

import org.springframework.stereotype.Service;

/**
 * Created by jt on 12/27/19.
 */
// Removed @Service annotation; Spring bean setup is now done in GreetingServiceConfig
public class SetterInjectedGreetingService implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Hello World - Setter";
    }
}
