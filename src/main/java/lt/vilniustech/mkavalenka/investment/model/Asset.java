package lt.vilniustech.mkavalenka.investment.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "asset")
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "asset_name")
    private String assetName;

    @Column(name = "quantity", precision = 65, scale = 4)
    private BigDecimal quantity;

    @OneToMany
    @JoinTable(
            name = "asset_transaction",
            joinColumns = @JoinColumn(name = "asset_id"),
            inverseJoinColumns = @JoinColumn(name = "transaction_id")
    )
    private List<Transaction> transactions;

}
