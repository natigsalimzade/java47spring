package az.ingress.java43spring.service;

import az.ingress.java43spring.dao.StudentDao;
import az.ingress.java43spring.exception.NoPermissionException;
import az.ingress.java43spring.exception.StudentNotFoundException;
import az.ingress.java43spring.model.Student;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentService {

    StudentDao studentDao;

    public List<Student> getAll(){
        return studentDao.getAll();
    }

    public Student getById(Integer id, String name, String surname){

        try {
            return studentDao.getById(id, name, surname);
        } catch (EmptyResultDataAccessException e) {
            throw new StudentNotFoundException("Student not found");
        }
    }

    public void add(Student student){
        studentDao.add(student);
    }

    public void update(Student student){
        studentDao.update(student);
    }

    public void delete(Integer id){
        studentDao.delete(id);
        log.info("Record deleted id = {}", id);
    }
}
