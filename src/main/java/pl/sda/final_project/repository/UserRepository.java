package pl.sda.final_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.final_project.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
