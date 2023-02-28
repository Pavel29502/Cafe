package cafe.repository;

import cafe.bean.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

//    List<Category> findById(Long id);

    void deleteById(Long id);
}
