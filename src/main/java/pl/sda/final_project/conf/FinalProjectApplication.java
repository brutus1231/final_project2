package pl.sda.final_project.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.sda.final_project.model.RoleType;
import pl.sda.final_project.model.User;
import pl.sda.final_project.model.UserRole;
import pl.sda.final_project.repository.RoleRepository;
import pl.sda.final_project.repository.UserRepository;

import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
@ComponentScan("pl.sda")
@EntityScan("pl.sda.final_project.model")
@EnableJpaRepositories("pl.sda.final_project.repository")
@Import(SecurityConfig.class)
public class FinalProjectApplication implements CommandLineRunner {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder encoder;

	public static void main(String[] args) {
		SpringApplication.run(FinalProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		if (userRepository.findAll().size() == 0) {
			UserRole userRole1 = new UserRole();
			userRole1.setType(RoleType.USER);
			userRole1 = roleRepository.save(userRole1);

			UserRole userRole2 = new UserRole();
			userRole2.setType(RoleType.ADMIN);
			userRole2 = roleRepository.save(userRole2);

			User user = new User();
			user.setUsername("user@wp.pl");
			user.setPassword(encoder.encode("haslo123"));
			user.setCreateDate(new Date());
			user.setCity("Poznań");
			user.setAddress("Nowa 20s");
			user.setRoles(Arrays.asList(userRole1));
			userRepository.save(user);

			User admin = new User();
			admin.setUsername("admin@wp.pl");
			admin.setPassword(encoder.encode("haslo123"));
			admin.setCreateDate(new Date());
			admin.setCity("Wawa");
			admin.setAddress("Wesoła 11");
			admin.setRoles(Arrays.asList(userRole2));
			userRepository.save(admin);
		}
	}
}
