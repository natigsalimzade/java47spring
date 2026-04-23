package az.ingress.java43spring.dao;

import az.ingress.java43spring.model.Student;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentDao {

    NamedParameterJdbcTemplate jdbcTemplate;

    public List<Student> getStudentList(){
        return jdbcTemplate.query(SQLQueries.SELECT_STUDENTS_LIST,
                new MapSqlParameterSource(),
                new BeanPropertyRowMapper<>(Student.class));
    }

    public Student getStudentById(Integer id){
        return jdbcTemplate.queryForObject(SQLQueries.SELECT_STUDENT_BY_ID,
                new MapSqlParameterSource("id", id),
                new BeanPropertyRowMapper<>(Student.class));
    }

    public void add(Student student){
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", student.getName());
        params.addValue("surname", student.getSurname());
        params.addValue("fatherName", student.getFatherName());
        params.addValue("grade", student.getGrade());
        jdbcTemplate.update(SQLQueries.INSERT_STUDENT, params);
    }

    public void update(Student student){
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", student.getId());
        params.addValue("name", student.getName());
        params.addValue("surname", student.getSurname());
        params.addValue("fatherName", student.getFatherName());
        params.addValue("grade", student.getGrade());
        jdbcTemplate.update(SQLQueries.UPDATE_STUDENT, params);
    }

    public void delete(Integer id){
        jdbcTemplate.update(SQLQueries.DELETE_STUDENT, new MapSqlParameterSource("id", id));
    }
}
