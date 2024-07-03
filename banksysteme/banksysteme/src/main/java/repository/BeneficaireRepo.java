package repository;

import model.Beneficiaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeneficaireRepo extends JpaRepository<Beneficiaire,Long> {
}
