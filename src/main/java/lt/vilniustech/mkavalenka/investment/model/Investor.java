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
@Table(name = "investor")
public class Investor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "login")
    private String login;

    @OneToMany
    @JoinTable(
            name = "investor_portfolio",
            joinColumns = @JoinColumn(name = "investor_id"),
            inverseJoinColumns = @JoinColumn(name = "portfolio_id")
    )
    private List<Portfolio> portfolios;

    public Investor(int id, String firstName, String lastName, String login) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
    }
}
