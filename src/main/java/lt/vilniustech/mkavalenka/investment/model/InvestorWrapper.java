package lt.vilniustech.mkavalenka.investment.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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
