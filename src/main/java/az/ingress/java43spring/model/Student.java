package az.ingress.java43spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private int id;
    private String name;
    private String surname;
    private String fatherName;
    private Double salary;
    private Integer cityId;

}
