package lt.vilniustech.mkavalenka.investment.db;

import lt.vilniustech.mkavalenka.investment.model.Investor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestorRepository extends JpaRepository<Investor, Long> {
}
