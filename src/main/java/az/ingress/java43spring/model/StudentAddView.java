package az.ingress.java43spring.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentAddView {

    Integer id;
    String name;
    String surname;
    String fullName;
}
