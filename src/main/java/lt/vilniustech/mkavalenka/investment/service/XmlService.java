package lt.vilniustech.mkavalenka.investment.service;


import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import lt.vilniustech.mkavalenka.investment.model.Investor;
import lt.vilniustech.mkavalenka.investment.model.InvestorWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;


@Service
public class XmlService {
    private final InvestorService investorService;

    @Autowired
    public XmlService(InvestorService investorService) {
        this.investorService = investorService;
    }


    /**
     * Converts a list of investors into an XML file.
     * <p>
     * This method retrieves all investors from the service, wraps them in an {@link InvestorWrapper},
     * and convert them into an XML file at the specified location.
     * </p>
     * @param  fileName The path where the XML file will be saved
     * @param  encoding The character encoding for the XML file (e.g., UTF-8)
     * @return The absolute file path of the generated XML file
     * @see InvestorWrapper
     */
    public String transformToXML(String fileName, String encoding) {
        File file = null;
        try {
            List<Investor> investors = investorService.getAllInvestors();
            InvestorWrapper investorWrapper = new InvestorWrapper(investors);

            JAXBContext jaxbContext = JAXBContext.newInstance(InvestorWrapper.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);;

            file = new File(fileName);
            jaxbMarshaller.marshal(investorWrapper, file);

        }
        catch (JAXBException e) {
            System.out.println("Error in XML conversion: " + e.getMessage());
        }


        return file.getAbsolutePath();
    }
}

