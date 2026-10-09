package az.ingress.java43spring.dao;

public interface SQLQueries {

    String SELECT_STUDENTS = "select * from students";

    String SELECT_STUDENT_BY_ID = "select * from students where id=:id and name=:name and surname=:surname";

    String INSERT_STUDENT = "insert into students(name, surname, father_name, salary, city_id) " +
            "values(:name, :surname, :fatherName, :salary, :cityId)";

    String UPDATE_STUDENT = "update students set name=:name, surname=:surname, father_name=:fatherName, " +
            "salary=:salary, city_id=:cityId where id=:id";

    String DELETE_STUDENT = "delete from students where id=:id";
}
