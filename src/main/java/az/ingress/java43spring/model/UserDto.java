package az.ingress.java43spring.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserDto {

    Integer id;
    String name;
    String lastname;
    String username;
}
