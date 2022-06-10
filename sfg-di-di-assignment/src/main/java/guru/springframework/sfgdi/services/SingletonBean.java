package guru.springframework.sfgdi.services;

import org.springframework.stereotype.Component;

// @Scope is singleton by default
@Component
public class SingletonBean {

    public SingletonBean() {
        System.out.println("Creating SingletonBean.");
    }

    public String getMyScope() {
        return "I'm a singleton!";
    }
}
