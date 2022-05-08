package com.marcfearby.sfgdi;

import com.marcfearby.sfgdi.controller.ConstructorInjectedController;
import com.marcfearby.sfgdi.controller.MyController;
import com.marcfearby.sfgdi.controller.PropertyInjectedController;
import com.marcfearby.sfgdi.controller.SetterInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

		MyController ctrl = (MyController)ctx.getBean("myController");

		String greeting = ctrl.sayHello();
		System.out.println("Greeting was: " + greeting);

		System.out.println("\nUse Spring to inject property-based dependencies:");
		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());
		// Results in this Exception: No bean named 'propertyInjectedController' available.
		// Spring expects @Controller (or @Component) on the class if you want to use getBean()
		// This now results in: Exception in thread "main" java.lang.NullPointerException
		// Because the greeting service property isn't being set automatically.
		// Adding @Autowired annotation to the greeting service property will fix it,
		// however this error will throw "No beans of 'GreetingService' type found"
		// until the @Service (or @Component) annotation is added to the GreetingServiceImpl (not interface)

		System.out.println("\nUse Spring to inject setter-based dependencies:");
		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");
		System.out.println(setterInjectedController.getGreeting());
		// Need to add @Controller and @Autowired to the setter method

		System.out.println("\nUse Spring to inject constructor-based dependencies:");
		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
		System.out.println(constructorInjectedController.getGreeting());
		// Only needs @Controller on the class. Adding @Autowired became optional with Spring >= 4.3 if the class has only one constructor
	}

}
