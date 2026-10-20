package az.ingress.java43spring.repository;

import az.ingress.java43spring.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findAllByNameOrSurnameOrderByIdDesc(String name, String surname);
}
