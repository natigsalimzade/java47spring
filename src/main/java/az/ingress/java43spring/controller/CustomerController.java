package az.ingress.java43spring.controller;

import az.ingress.java43spring.model.dto.CustomerDTO;
import az.ingress.java43spring.model.entity.Customer;
import az.ingress.java43spring.service.CustomerService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/customers")
public class CustomerController {

    CustomerService customerService;

    @GetMapping
    public List<CustomerDTO> findAll(){
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public CustomerDTO findById(@PathVariable Integer id){
        return customerService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDTO add(@RequestBody Customer customer){
        return customerService.add(customer);
    }

    @PutMapping
    public CustomerDTO update(@RequestBody Customer customer){
        return customerService.update(customer);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Integer id){
        customerService.deleteById(id);
    }

    @GetMapping("/name-or-surname")
    public List<CustomerDTO> findAllByNameOrSurnameOrderByIdDesc(@RequestParam String name,
                                                              @RequestParam String surname){
        return customerService.findAllByNameOrSurnameOrderByIdDesc(name, surname);
    }
}
