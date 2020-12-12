package pl.sda.final_project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.final_project.assebler.UserAssembler;
import pl.sda.final_project.dto.UserDto;
import pl.sda.final_project.model.RoleType;
import pl.sda.final_project.model.User;
import pl.sda.final_project.model.UserRole;
import pl.sda.final_project.repository.RoleRepository;
import pl.sda.final_project.repository.UserRepository;

import java.util.Arrays;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserAssembler userAssembler;
    private final RoleRepository roleRepository;

    public Long save(UserDto userDto) {
        User user = userAssembler.toEntity(userDto);
        Optional<UserRole> userRole = roleRepository.findByType(RoleType.USER);
        user.setRoles(Arrays.asList(userRole.get()));
        User savedUser = userRepository.save(user);
        return savedUser.getId();
    }
}
