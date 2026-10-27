package az.ingress.java43spring;

import az.ingress.java43spring.exception.CustomerNotFoundException;
import az.ingress.java43spring.model.entity.City;
import az.ingress.java43spring.model.entity.Customer;
import az.ingress.java43spring.repository.CityRepository;
import az.ingress.java43spring.repository.CustomerRepository;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootApplication
@EnableFeignClients
@Slf4j
@RequiredArgsConstructor
public class Java43springApplication implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final CityRepository cityRepository;

    public static void main(String[] args) {
        SpringApplication.run(Java43springApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // test message
        // test message vol2
        // test message vol3
        // test message vol4
        // test message vol5
        // test message vol7
        // test message vol8
        // test message vol9
    }
}
