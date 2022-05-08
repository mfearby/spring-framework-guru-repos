package com.marcfearby.sfgdi;

import com.marcfearby.sfgdi.controller.MyController;
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
	}

}
