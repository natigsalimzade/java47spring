package az.ingress.java43spring.dao;

public interface SQLQueries {

    String SELECT_STUDENTS_LIST = "select * from students";

    String SELECT_STUDENT_BY_ID = "select * from students where id=:id";

    String INSERT_STUDENT = "insert into students(name, surname, father_name, grade) values(:name, :surname, :fatherName, :grade)";

    String UPDATE_STUDENT = "update students set name=:name, surname=:surname, father_name=:fatherName, grade=:grade where id=:id";

    String DELETE_STUDENT = "delete from students where id=:id";
}
