package lt.vilniustech.mkavalenka.investment.service;

import lt.vilniustech.mkavalenka.investment.db.PortfolioRepository;
import lt.vilniustech.mkavalenka.investment.model.Portfolio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioService {
    private final PortfolioRepository portfolioRepository;

    public PortfolioService (PortfolioRepository portfolioRepository){
        this.portfolioRepository = portfolioRepository;
    }

    public List<Portfolio> getAllPortfolios() {
        return portfolioRepository.findAll();
    }


}

