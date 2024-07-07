package tech.bank.banksysteme.repository;

import tech.bank.banksysteme.model.Transfert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransfertRepo extends JpaRepository<Transfert, Long> {
}
