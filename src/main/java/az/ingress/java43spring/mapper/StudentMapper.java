package az.ingress.java43spring.mapper;

import az.ingress.java43spring.model.Student;
import az.ingress.java43spring.model.StudentAddView;
import az.ingress.java43spring.model.StudentView;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    @Mapping(source = "surname", target = "lastname")
    @Mapping(source = "fatherName", target = "patronymic")
    @Mapping(source = "student", target = "fullName", qualifiedByName = "mapFullName")
    StudentView toStudentView(Student student);

    @Mapping(source = "ad", target = "name")
    @Mapping(source = "soyad", target = "surname")
    @Mapping(source = "ata", target = "fatherName")
    @Mapping(source = "bal", target = "grade")
    Student toStudent(StudentAddView studentAddView);

    @Named("mapFullName")
    default String mapFullName(Student student){
        return student.getSurname() + " " + student.getName() + " " + student.getFatherName();
    }
}
