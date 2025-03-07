package lt.vilniustech.mkavalenka.investment.service;

import lt.vilniustech.mkavalenka.investment.db.TransactionRepository;
import lt.vilniustech.mkavalenka.investment.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionService (TransactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
}

