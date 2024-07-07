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

    /**
     * Retrieves all transactions from the repository.
     *
     * @return List of all transactions stored in the repository.
     */
    public List<Transaction> getAllTransactions() {
        return transactionRepo.findAll();
    }

    /**
     * Retrieves a transaction by its unique identifier.
     *
     * @param id The unique identifier of the transaction to retrieve.
     * @return The transaction corresponding to the provided id.
     * @throws RuntimeException If no transaction exists with the provided id.
     */
    public Transaction getTransactionById(Long id) {
        return transactionRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found with id: " + id));
    }

    /**
     * Creates a new transaction and updates the associated compte bancaire's balance.
     *
     * @param transaction The transaction object to be created.
     * @return The created transaction object.
     * @throws IllegalArgumentException If the associated compte bancaire is null.
     * @throws RuntimeException         If the associated compte bancaire cannot be found.
     */
    @Transactional
    public Transaction createTransaction(Transaction transaction) {
        CompteBancaire compteBancaire = transaction.getCompteBancaire();
        if (compteBancaire == null) {
            throw new IllegalArgumentException("Compte bancaire cannot be null.");
        }

        // Fetch the compteBancaire from the database to ensure it's managed
        compteBancaire = compteBancaireRepo.findById(compteBancaire.getId())
                .orElseThrow(() -> new RuntimeException("Compte bancaire not found."));

        // Update the balance based on transaction type
        double newBalance = compteBancaire.getSoldeInitial();
        if ("Crédit".equals(transaction.getType())) {
            newBalance += transaction.getMontant();
        } else {
            newBalance -= transaction.getMontant();
        }
        compteBancaire.setSoldeInitial(newBalance);

        // Save the updated compteBancaire in the database
        compteBancaireRepo.save(compteBancaire);

        // Save the transaction
        return transactionRepo.save(transaction);
    }

    /**
     * Updates an existing transaction with new details.
     *
     * @param id                The unique identifier of the transaction to update.
     * @param transactionDetails The updated transaction details.
     * @return The updated transaction object.
     * @throws RuntimeException If no transaction exists with the provided id.
     */
    public Transaction updateTransaction(Long id, Transaction transactionDetails) {
        Transaction transaction = getTransactionById(id);
        transaction.setDateHeure(transactionDetails.getDateHeure());
        transaction.setMontant(transactionDetails.getMontant());
        transaction.setType(transactionDetails.getType());
        transaction.setDescription(transactionDetails.getDescription());
        return transactionRepo.save(transaction);
    }

    /**
     * Deletes a transaction from the repository.
     *
     * @param id The unique identifier of the transaction to delete.
     */
    public void deleteTransaction(Long id) {
        transactionRepo.deleteById(id);
    }
}
