package cafe.repository;

import cafe.bean.Preorder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreorderRepository extends JpaRepository<Preorder, Long> {
}
