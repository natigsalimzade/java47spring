package az.ingress.java43spring;


import az.ingress.java43spring.configuration.MyConfig;
import az.ingress.java43spring.model.Student;
import az.ingress.java43spring.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@SpringBootApplication
@Slf4j
public class Java43springApplication implements CommandLineRunner {



    public static void main(String[] args) {
        SpringApplication.run(Java43springApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {


//        String url = "jdbc:mysql://localhost:3306/java51";
//        String name = "Sema";
//        String surname = "' or '1'='1";
//
//        try (Connection conn = DriverManager.getConnection(url, "root", "password");
//             Statement st = conn.createStatement()) {
//
//            String sql = "SELECT * FROM students WHERE name = '" + name
//                    + "' AND surname = '" + surname + "'";
//
//            System.out.println("İcra olunan sorğu: " + sql);
//
//            try (ResultSet rs = st.executeQuery(sql)) {
//                if (rs.next()) {
//                    System.out.println("Xoş gəldin, " + rs.getString("salary") + "!");
//                } else {
//                    System.out.println("Ad və ya soyad səhvdir.");
//                }
//            }
//        }
    }
}
