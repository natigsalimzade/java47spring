package az.ingress.java43spring.dao;

import az.ingress.java43spring.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDao {

    public List<Student> getStudentList(){
        return List.of(
                new Student(1, "Fidan", "Aliyeva"),
                new Student(2, "Firudin", "Mammadov"),
                new Student(3, "Khazar", "Baghirov")
        );
    }

    public Student getStudent(Integer id,
                              String name,
                              String surname){
        return new Student(id, name, surname);
    }

    public Student add(Student student){
        student.setId(1);
        return student;
    }

    public Student update(Student student){
        return student;
    }

    public void delete(Integer id){}
}
