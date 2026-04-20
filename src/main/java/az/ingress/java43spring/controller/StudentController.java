package az.ingress.java43spring.controller;

import az.ingress.java43spring.model.Student;
import az.ingress.java43spring.model.StudentAddView;
import az.ingress.java43spring.model.StudentView;
import az.ingress.java43spring.service.StudentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/students")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentController {

    StudentService studentService;

    @GetMapping
    public List<Student> getStudentList(){
        return studentService.getStudentList();
    }

    @GetMapping("/{id}")
    public StudentView getStudent(@PathVariable Integer id,
                                  @RequestParam String name,
                                  @RequestParam(required = false) String surname){
        return studentService.getStudent(id, name, surname);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentAddView add(@RequestBody Student student){
        return studentService.add(student);
    }

    @PutMapping
    public Student update(@RequestBody Student student){
        return studentService.update(student);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        studentService.delete(id);
    }
}
