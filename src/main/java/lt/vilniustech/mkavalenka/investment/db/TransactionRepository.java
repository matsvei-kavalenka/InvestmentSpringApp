package lt.vilniustech.mkavalenka.investment.db;

import lt.vilniustech.mkavalenka.investment.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
