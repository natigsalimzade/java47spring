package az.ingress.java43spring;


import az.ingress.java43spring.config.MyConfig;
import az.ingress.java43spring.model.Customer;
import az.ingress.java43spring.model.Student;
import az.ingress.java43spring.model.entity.City;
import az.ingress.java43spring.model.entity.Country;
import az.ingress.java43spring.model.entity.Project;
import az.ingress.java43spring.model.entity.User;
import az.ingress.java43spring.repository.CountryRepository;
import az.ingress.java43spring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
public class Java43springApplication implements CommandLineRunner {

	private final UserRepository userRepository;
	private final CountryRepository countryRepository;

	public static void main(String[] args) {
		SpringApplication.run(Java43springApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Country country = new Country();
		country.setName("Turkey");

		City city = new City();
		city.setName("Baku");

		User user = new User();
		user.setName("Firudin");
		user.setSurname("Mammadov");
		user.setFatherName("Maharram");
		user.setUsername("firudin");

		user.setCountry(country);
		user.setCity(city);

		Project project = new Project();
		project.setName("MP");
		project.setUser(user);

		Project project1 = new Project();
		project1.setName("GP");
		project1.setUser(user);

		user.setProjects(List.of(project, project1));

		userRepository.save(user);


	}
}
