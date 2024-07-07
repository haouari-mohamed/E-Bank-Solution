package tech.bank.banksysteme.repository;

import tech.bank.banksysteme.model.Beneficiaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeneficaireRepo extends JpaRepository<Beneficiaire,Long> {
}
