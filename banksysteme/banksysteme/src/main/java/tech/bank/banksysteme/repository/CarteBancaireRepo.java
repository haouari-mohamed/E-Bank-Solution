package tech.bank.banksysteme.repository;

import tech.bank.banksysteme.model.CarteBancaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarteBancaireRepo extends JpaRepository<CarteBancaire, Long> {
}
