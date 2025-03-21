package lt.vilniustech.mkavalenka.investment.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Wrapper class for a list of {@link Investor} objects for XML serialization.
 * <p>
 * This class is used to wrap a list of investors so that it can be properly converted
 * into an XML format, where the list of investors will be represented under the root element
 * named "investors". Each individual investor will be represented as an "investor" element.
 * </p>
 */
@NoArgsConstructor
@Setter
@XmlRootElement(name = "investors")
public class InvestorWrapper {
    private List<Investor> investors;

    public InvestorWrapper(List<Investor> investors) {
        this.investors = investors;
    }

    @XmlElement(name = "investor")
    public List<Investor> getInvestors() {
        return investors;
    }
}
