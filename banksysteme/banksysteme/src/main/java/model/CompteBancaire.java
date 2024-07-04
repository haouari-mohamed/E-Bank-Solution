package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
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

    @ManyToOne
    @JoinColumn(name = "utilisateur_id", nullable = false)
    private Utilisateur utilisateur;

    @OneToMany(mappedBy = "compteBancaire", cascade = CascadeType.ALL)
    private List<Transaction> transactions;

    @OneToMany(mappedBy = "compteBancaire", cascade = CascadeType.ALL)
    private List<CarteBancaire> cartesBancaires;

    @OneToMany(mappedBy = "compteBancaire", cascade = CascadeType.ALL)
    private List<Transfert> transferts;


}