package az.ingress.java43spring.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentView {

    Integer id;
    String name;
    String lastname;
    String patronymic;
    Integer grade;
    String fullName;
}
