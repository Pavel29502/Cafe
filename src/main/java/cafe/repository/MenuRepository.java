package cafe.repository;

import cafe.bean.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {
//    public List<Product> findByCategory_CategoryId(long CategoryId);
//    public List<Menu> findByCategory();
//    List<Menu> findById(Long id);
    List<Menu> findByTitle(String title);

}
