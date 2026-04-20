package az.ingress.java43spring.config;

import az.ingress.java43spring.model.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean("test")
    public Student getStudent(){
        return new Student(1, "Fidan", "Aliyeva");
    }
}
