package lt.vilniustech.mkavalenka.investment.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

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


