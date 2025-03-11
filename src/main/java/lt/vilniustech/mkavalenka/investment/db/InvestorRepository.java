package lt.vilniustech.mkavalenka.investment.db;

import lt.vilniustech.mkavalenka.investment.model.Investor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvestorRepository extends JpaRepository<Investor, Long> {
    Investor findById(int id);
}
