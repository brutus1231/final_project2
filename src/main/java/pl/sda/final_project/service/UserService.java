package pl.sda.final_project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.final_project.assebler.UserAssembler;
import pl.sda.final_project.dto.UserDto;
import pl.sda.final_project.model.User;
import pl.sda.final_project.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserAssembler userAssembler;

    public Long save(UserDto userDto) {
        User user = userAssembler.toEntity(userDto);
        User savedUser = userRepository.save(user);
        return savedUser.getId();
    }
}
