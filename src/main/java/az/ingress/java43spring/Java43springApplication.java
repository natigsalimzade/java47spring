package az.ingress.java43spring;

import az.ingress.java43spring.exception.CustomerNotFoundException;
import az.ingress.java43spring.model.entity.Customer;
import az.ingress.java43spring.repository.CustomerRepository;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@Slf4j
@RequiredArgsConstructor
public class Java43springApplication implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    public static void main(String[] args) {
        SpringApplication.run(Java43springApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

//        Customer customer = customerRepository.findById(6).orElseThrow(CustomerNotFoundException::new);
//
//        log.info("customer = {}", customer);
//        log.info("cityName = {}", customer.getCity().getName());

//        Customer customer = new Customer();
//        customer.setName("Khurrami");
//        customer.setSurname("Abbaszade");
//        customer.setFatherName("Elnur");
//        customer.setAddress("Baku");
//        customer.setCityId(3);
//
//        customerRepository.save(customer);
//
//        customer.setAddress("California");

    }
}
