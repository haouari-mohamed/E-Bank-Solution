package repository;

import model.Beneficiaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BenificaireRepo extends JpaRepository<Beneficiaire,Long> {
}
