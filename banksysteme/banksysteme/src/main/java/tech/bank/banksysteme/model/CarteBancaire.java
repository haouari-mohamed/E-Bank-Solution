package tech.bank.banksysteme.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "cartes_bancaires")
public class CarteBancaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String numero;

    @Column(nullable = false)
    private Date dateExpiration;

    @Column(nullable = false)
    private String type;

    private String raisonBlocage;

    @ManyToOne
    @JoinColumn(name = "compte_bancaire_id", nullable = false)
    private CompteBancaire compteBancaire;

}
