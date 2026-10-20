package az.ingress.java43spring.model.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CityDto {

    Integer id;
    String name;
    List<CustomerDTO> customers;
}
