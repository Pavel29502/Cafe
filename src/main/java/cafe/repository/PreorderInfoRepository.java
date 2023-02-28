package cafe.repository;

import cafe.bean.PreorderInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreorderInfoRepository extends JpaRepository<PreorderInfo, Long> {
}
