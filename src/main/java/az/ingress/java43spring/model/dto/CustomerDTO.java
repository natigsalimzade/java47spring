package az.ingress.java43spring.model.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerDTO {

    Integer id;
    String name;
    String surname;
    String fatherName;
    String address;
    CityDTO city;


    @Data
    public static class CityDTO {
        private Integer id;
        private String name;
    }
}
