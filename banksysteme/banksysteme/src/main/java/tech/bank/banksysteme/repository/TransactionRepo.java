package tech.bank.banksysteme.repository;

import tech.bank.banksysteme.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepo extends JpaRepository<Transaction, Long> {
}
