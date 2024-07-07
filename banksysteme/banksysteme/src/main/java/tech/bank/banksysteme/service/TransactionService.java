package tech.bank.banksysteme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.bank.banksysteme.model.CompteBancaire;
import tech.bank.banksysteme.model.Transaction;
import tech.bank.banksysteme.repository.CompteBancaireRepo;
import tech.bank.banksysteme.repository.TransactionRepo;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepo transactionRepo;

    @Autowired
    private CompteBancaireRepo compteBancaireRepo; // Inject your repository for CompteBancaire

    public List<Transaction> getAllTransactions() {
        return transactionRepo.findAll();
    }

    public Transaction getTransactionById(Long id) {
        return transactionRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found with id: " + id));
    }

    @Transactional
    public Transaction createTransaction(Transaction transaction) {
        CompteBancaire compteBancaire = transaction.getCompteBancaire();
        if (compteBancaire == null) {
            throw new IllegalArgumentException("Compte bancaire cannot be null.");
        }

        // Fetch the compteBancaire from the database to ensure it's managed
        compteBancaire = compteBancaireRepo.findById(compteBancaire.getId())
                .orElseThrow(() -> new RuntimeException("Compte bancaire not found."));

        double newBalance = compteBancaire.getSoldeInitial();
        if ("Crédit".equals(transaction.getType())) {
            newBalance += transaction.getMontant();
        } else {
            newBalance -= transaction.getMontant();
        }
        compteBancaire.setSoldeInitial(newBalance);

        // Update the compteBancaire in the database
        compteBancaireRepo.save(compteBancaire);

        // Save the transaction
        return transactionRepo.save(transaction);
    }

    public Transaction updateTransaction(Long id, Transaction transactionDetails) {
        Transaction transaction = getTransactionById(id);
        transaction.setDateHeure(transactionDetails.getDateHeure());
        transaction.setMontant(transactionDetails.getMontant());
        transaction.setType(transactionDetails.getType());
        transaction.setDescription(transactionDetails.getDescription());
        return transactionRepo.save(transaction);
    }

    public void deleteTransaction(Long id) {
        transactionRepo.deleteById(id);
    }
}
