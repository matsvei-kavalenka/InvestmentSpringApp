package lt.vilniustech.mkavalenka.investment.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;


/**
 * Represents a portfolio in the system.
 * <p>
 * A portfolio is an entity that stores different assets of the investor.
 * This class holds portfolio's name.
 * It also maintains a relationship to the assets of that portfolio.
 * </p>
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "portfolio")
public class Portfolio {
    @Id
    @GeneratedValue(strategy =   GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "portfolio_name")
    private String portfolioName;

    /**
     * A list of assets in the portfolio.
     * The portfolio can have multiple assets.
     */
    @OneToMany
    @JoinTable(
            name = "portfolio_asset",
            joinColumns = @JoinColumn(name = "portfolio_id"),
            inverseJoinColumns = @JoinColumn(name = "asset_id")
    )
    private List<Asset> assets;

    public Portfolio(int id, String portfolioName) {
        this.id = id;
        this.portfolioName = portfolioName;
    }
}


