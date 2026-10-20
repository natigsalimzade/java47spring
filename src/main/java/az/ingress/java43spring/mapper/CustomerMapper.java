package az.ingress.java43spring.mapper;

import az.ingress.java43spring.model.dto.CustomerDTO;
import az.ingress.java43spring.model.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDTO toCustomerDto(Customer customer);

    List<CustomerDTO> toCustomerDtoList(List<Customer> customerList);


    @Named("mapFullName")
    default String mapFullName(Customer customer){
        return customer.getName() + " " + customer.getSurname();
    }
}
