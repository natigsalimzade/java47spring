package az.ingress.java43spring.service;

import az.ingress.java43spring.dao.StudentDao;
import az.ingress.java43spring.mapper.StudentMapper;
import az.ingress.java43spring.model.Student;
import az.ingress.java43spring.model.StudentAddView;
import az.ingress.java43spring.model.StudentView;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentService {

    StudentDao studentDao;
    StudentMapper studentMapper;

    public List<Student> getStudentList(){
        return studentDao.getStudentList();
    }

    public StudentView getStudent(Integer id){
        Student student = studentDao.getStudentById(id);
        return studentMapper.toStudentView(student);
    }

    public void add(StudentAddView studentAddView){
        Student student = studentMapper.toStudent(studentAddView);
        studentDao.add(student);
    }

    public void update(Student student){
        studentDao.update(student);
    }

    public void delete(Integer id){
        studentDao.delete(id);
        log.info("Record was deleted with id = {}", id);
    }
}
