package tech.bank.banksysteme.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "comptes_bancaires")
public class CompteBancaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private double soldeInitial;

    @Column(nullable = false)
    private Date dateCreation;

    private String raisonFermeture;

    @Column(nullable = false)
    private boolean active;

    @Column(nullable = false)
    private boolean closed;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id", nullable = false)
    private Utilisateur utilisateur;

    @OneToMany(mappedBy = "compteBancaire", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Transaction> transactions;

    @OneToMany(mappedBy = "compteBancaire", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<CarteBancaire> cartesBancaires;

    @OneToMany(mappedBy = "compteBancaire", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Transfert> transferts;
}
