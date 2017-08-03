package sa.com.rufaida.app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages ={"sa.com.rufaida.config"})
public class Application {
    
    public static void main(String[] args) {
    	 SpringApplication.run(Application.class, args);
    	 System.out.println("Let's service run by Spring Boot:");
    }

}
