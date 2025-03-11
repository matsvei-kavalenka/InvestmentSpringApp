package lt.vilniustech.mkavalenka.investment.service;


import lt.vilniustech.mkavalenka.investment.db.InvestorRepository;
import lt.vilniustech.mkavalenka.investment.model.Investor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestorService {
    private final InvestorRepository investorRepository;

    public InvestorService (InvestorRepository investorRepository){
        this.investorRepository = investorRepository;
    }

    public List<Investor> getAllInvestors() {
        return investorRepository.findAll();
    }
}
