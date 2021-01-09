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

    public void update(UserDto userDto){
        Optional<User> optionalUser = userRepository.findById(userDto.getId());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
//            user.setId(userDto.getId());
            user.setCity(userDto.getCity());
            user.setAddress(userDto.getAddress());
            userRepository.save(user);
        }
    }

    public void delete(Long userId) {
        userRepository.deleteById(userId);
    }
}
