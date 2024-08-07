package tech.bank.banksysteme.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "beneficiaires")
public class Beneficiaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String numeroCompte;

    @Column(nullable = false)
    private String banque;

    @OneToMany(mappedBy = "beneficiaire", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Transfert> transferts;

}
