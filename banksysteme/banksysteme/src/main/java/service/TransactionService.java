package service;

import model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.TransactionRepo;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepo transactionRepo;

    public List<Transaction> getAllTransactions(){
        return  transactionRepo.findAll();
    }
    public Transaction getTransactionById(Long id) {
        return transactionRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found with id: " + id));
    }
    public Transaction createTransaction(Transaction transaction){
        return  transactionRepo.save(transaction);
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
