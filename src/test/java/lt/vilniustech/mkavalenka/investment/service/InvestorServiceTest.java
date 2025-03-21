package lt.vilniustech.mkavalenka.investment.service;

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

/**
 * Test class for {@link InvestorService}.
 * <p>
 * This test verifies the behavior of the {@link InvestorService} when retrieving all investors
 * from the repository. It uses mocking to simulate the repository's behavior.
 * </p>
 */
@ExtendWith(MockitoExtension.class)
public class InvestorServiceTest {
    @Mock
    private InvestorRepository investorRepository;

    @InjectMocks
    private InvestorService investorService;

    /**
     * Verifies that the {@link InvestorService#getAllInvestors()} method correctly retrieves
     * the list of investors from the repository.
     * <p>
     * This test mocks the repository's behavior to return a predefined list of investors and
     * checks if the service method correctly returns the same list.
     * </p>
     */
    @Test
    public void testGetAllInvestors() {
        List<Investor> investors = Arrays.asList(
                new Investor(1, "Matsvei", "Kavalenka", "mtsv"),
                new Investor(2, "Zlata", "Dovydkova", "zldvk")
        );
        // Mock the repository method to return the list of investors
        Mockito.when(investorRepository.findAll()).thenReturn(investors);

        List<Investor> result = investorService.getAllInvestors();

        assertEquals(2, result.size());
    }

}

