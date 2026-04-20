package az.ingress.java43spring;


import az.ingress.java43spring.config.MyConfig;
import az.ingress.java43spring.model.Customer;
import az.ingress.java43spring.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
@Slf4j
public class Java43springApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Java43springApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {



	}
}
