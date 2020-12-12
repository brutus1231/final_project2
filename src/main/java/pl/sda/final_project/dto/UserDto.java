package pl.sda.final_project.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.final_project.model.AccountStatus;

import java.util.Date;

@Data
@NoArgsConstructor
public class UserDto {

    private Long id;
    private String username;
    private String confirmedPassword;
    private String password;
    private String city;
    private String address;
    private Date createDate;
    private AccountStatus status;
    private byte[] avatar;
}
