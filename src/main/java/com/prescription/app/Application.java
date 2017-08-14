package com.prescription.app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages ={"com.prescription.config"})
public class Application {
    
    public static void main(String[] args) {
    	 SpringApplication.run(Application.class, args);
    	 System.out.println("\n \n ==================== Let's service run by Spring Boot: ===================="
    	 		+ "\n \n");
    }

}
