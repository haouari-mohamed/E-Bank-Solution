package repository;

import model.CarteBancaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarteBancaireRepo extends JpaRepository<CarteBancaire, Long> {
}
