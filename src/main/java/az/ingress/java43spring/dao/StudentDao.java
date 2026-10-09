package az.ingress.java43spring.dao;

import az.ingress.java43spring.model.Student;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.processing.SQL;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentDao {

    NamedParameterJdbcTemplate jdbcTemplate;

    public List<Student> getAll(){
        return jdbcTemplate.query(SQLQueries.SELECT_STUDENTS,
                new MapSqlParameterSource(), new BeanPropertyRowMapper<>(Student.class));
    }

    public Student getById(Integer id, String name, String surname){
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        params.addValue("name", name);
        params.addValue("surname", surname);
        return jdbcTemplate.queryForObject(SQLQueries.SELECT_STUDENT_BY_ID,
                params, new BeanPropertyRowMapper<>(Student.class));
    }

    public void add(Student student){
        jdbcTemplate.update(SQLQueries.INSERT_STUDENT, new BeanPropertySqlParameterSource(student));
    }

    public void update(Student student){
        jdbcTemplate.update(SQLQueries.UPDATE_STUDENT, new BeanPropertySqlParameterSource(student));
    }

    public void delete(Integer id){
        jdbcTemplate.update(SQLQueries.DELETE_STUDENT, new MapSqlParameterSource("id", id));
    }
}
