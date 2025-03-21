package lt.vilniustech.mkavalenka.investment.service;


import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import lt.vilniustech.mkavalenka.investment.db.InvestorRepository;
import lt.vilniustech.mkavalenka.investment.model.Investor;
import lt.vilniustech.mkavalenka.investment.model.InvestorWrapper;
import lt.vilniustech.mkavalenka.investment.model.Portfolio;
import lt.vilniustech.mkavalenka.investment.service.InvestorService;
import lt.vilniustech.mkavalenka.investment.service.XmlService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


/**
 * Test class for {@link XmlService}.
 * <p>
 * This test verifies the behavior of the {@link XmlService#transformToXML(String, String)} method.
 * It checks if the service correctly generates an XML file, and the content of the XML file
 * matches the expected structure and data.
 * </p>
 */
@ExtendWith(MockitoExtension.class)
public class XmlServiceTest {

    @Mock
    private InvestorService investorService;

    @InjectMocks
    private XmlService xmlService;


    /**
     * Verifies that the {@link XmlService#transformToXML(String, String)} method correctly generates
     * an XML file containing a list of investors and that the generated XML file matches the expected format.
     * <p>
     * This test checks if the XML file is created, contains data, and can be unmarshalled correctly into
     * an {@link InvestorWrapper} object.
     * </p>
     *
     * @throws JAXBException If there is an error during XML processing.
     * @throws FileNotFoundException If the generated XML file cannot be found.
     */
    @Test
    public void testTransformToXML() throws JAXBException, FileNotFoundException {
        List<Investor> investors = Arrays.asList(
                new Investor(1, "Matsvei", "Kavalenka", "mtsv"),
                new Investor(2, "Zlata", "Dovydkova", "zldvk")
        );
        // Mock the service call to return a predefined list of investors
        when(investorService.getAllInvestors()).thenReturn(investors);

        String filePath = xmlService.transformToXML("data.xml", "UTF-8");

        File file = new File(filePath);
        assertTrue(file.exists(), "The XML file should be created");
        assertTrue(file.length() > 0, "The XML file should not be empty");

        JAXBContext jaxbContext = JAXBContext.newInstance(InvestorWrapper.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        InvestorWrapper investorWrapper = (InvestorWrapper) unmarshaller.unmarshal(new FileReader(file));

        assertNotNull(investorWrapper, "InvestorWrapper should not be null");
        assertEquals(2, investorWrapper.getInvestors().size(), "Investor list size should match");

        Investor firstInvestor = investorWrapper.getInvestors().get(0);
        assertEquals(1, firstInvestor.getId());
        assertEquals("Matsvei", firstInvestor.getFirstName());
        assertEquals("Kavalenka", firstInvestor.getLastName());
        assertEquals("mtsv", firstInvestor.getLogin());

        Investor secondInvestor = investorWrapper.getInvestors().get(1);
        assertEquals(2, secondInvestor.getId());
        assertEquals("Zlata", secondInvestor.getFirstName());
        assertEquals("Dovydkova", secondInvestor.getLastName());
        assertEquals("zldvk", secondInvestor.getLogin());

    }

}
