package lt.vilniustech.mkavalenka.investment.unit_tests.service;

import lt.vilniustech.mkavalenka.investment.db.InvestorRepository;
import lt.vilniustech.mkavalenka.investment.model.Investor;
import lt.vilniustech.mkavalenka.investment.service.InvestorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class InvestorServiceTest {

    @Mock
    private InvestorRepository investorRepository;

    @InjectMocks
    private InvestorService investorService;

    @Test
    public void testGetAllInvestors() {
        List<Investor> investors = Arrays.asList(
                new Investor(1, "Matsvei", "Kavalenka", "mtsv"),
                new Investor(2, "Zlata", "Dovydkova", "zldvk")
        );

        Mockito.when(investorRepository.findAll()).thenReturn(investors);

        List<Investor> result = investorService.getAllInvestors();

        assertEquals(2, result.size());
    }

}

