package tech.bank.banksysteme.repository;

import tech.bank.banksysteme.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepo extends JpaRepository<Utilisateur, Long> {
    Utilisateur findUtilisateurByUsername(String username);

}
