package pl.sda.final_project.mapper;

import org.mapstruct.Mapper;
import pl.sda.final_project.dto.UserDto;
import pl.sda.final_project.model.User;

@Mapper
public interface UserMapper {

    User map(UserDto userDto);
}
