package lt.vilniustech.mkavalenka.investment.db;

import lt.vilniustech.mkavalenka.investment.model.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Long> {
}

