package lt.vilniustech.mkavalenka.investment.db;

import lt.vilniustech.mkavalenka.investment.model.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {

}
