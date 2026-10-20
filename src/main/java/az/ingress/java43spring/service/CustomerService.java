package az.ingress.java43spring.service;

import az.ingress.java43spring.exception.CustomerNotFoundException;
import az.ingress.java43spring.mapper.CustomerMapper;
import az.ingress.java43spring.model.dto.CustomerDTO;
import az.ingress.java43spring.model.entity.Customer;
import az.ingress.java43spring.repository.CustomerRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class CustomerService {

    CustomerRepository customerRepository;
    CustomerMapper customerMapper;

    public List<CustomerDTO> findAll(){
        List<Customer> customerList = customerRepository.findAll();
        return customerMapper.toCustomerDtoList(customerList);
    }

    public CustomerDTO findById(Integer id){
        Customer customer = customerRepository.findById(id).orElseThrow(CustomerNotFoundException::new);
        return customerMapper.toCustomerDto(customer);
    }

    public CustomerDTO add(Customer customer){
        return customerMapper.toCustomerDto(customerRepository.save(customer));
    }

    public CustomerDTO update(Customer customer){
        customerRepository.findById(customer.getId())
                .orElseThrow(CustomerNotFoundException::new);

        return customerMapper.toCustomerDto(customerRepository.save(customer));
    }

    public void deleteById(Integer id){
        customerRepository.deleteById(id);
    }

    public List<CustomerDTO> findAllByNameOrSurnameOrderByIdDesc(String name, String surname){
        return customerMapper.toCustomerDtoList(customerRepository.findAllByNameOrSurnameOrderByIdDesc(name, surname));
    }
}
