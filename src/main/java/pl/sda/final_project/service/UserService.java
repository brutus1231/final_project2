package pl.sda.final_project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.final_project.dto.UserDto;
import pl.sda.final_project.mapper.UserMapper;
import pl.sda.final_project.model.User;
import pl.sda.final_project.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public Long save(UserDto userDto) {
        User user = userMapper.map(userDto);
        User savedUser = userRepository.save(user);
        return savedUser.getId();
    }
}
