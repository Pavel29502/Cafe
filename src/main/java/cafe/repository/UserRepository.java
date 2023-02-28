package cafe.repository;

import cafe.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
List<User> findByName(String name);
void deleteById(Long id);


}
