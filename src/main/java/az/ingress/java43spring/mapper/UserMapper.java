package az.ingress.java43spring.mapper;

import az.ingress.java43spring.model.UserDto;
import az.ingress.java43spring.model.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUser(UserDto userDto);

    List<UserDto> toUserDtoList(List<User> users);

    UserDto toUserDto(User user);
}
