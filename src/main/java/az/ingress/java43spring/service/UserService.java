package az.ingress.java43spring.service;

import az.ingress.java43spring.exception.UserNotFoundException;
import az.ingress.java43spring.mapper.UserMapper;
import az.ingress.java43spring.model.UserDto;
import az.ingress.java43spring.model.entity.User;
import az.ingress.java43spring.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {

    UserRepository userRepository;
    UserMapper userMapper;

    public void add(UserDto userDto){
        User user = userMapper.toUser(userDto);
        log.info("user = {}", user);
        userRepository.save(user);
    }

    public List<UserDto> getAll(){
        List<User> users = userRepository.findAll();
        return userMapper.toUserDtoList(users);
    }

    public UserDto findById(Integer id){
        log.info("User by name = " + userRepository.findByName("Orxan"));
        User user = userRepository.findById(id).orElseThrow(NullPointerException::new);
        return userMapper.toUserDto(user);
    }

    public void update(UserDto userDto){
        User user = userMapper.toUser(userDto);
        userRepository.save(user);
    }

    public void deleteById(Integer id){
        userRepository.deleteById(id);
    }

}
