package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
@Getter
@Setter
@Entity
@Table(name = "utilisateurs")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String motDePasse;

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    private List<CompteBancaire> compteBancaires;



}