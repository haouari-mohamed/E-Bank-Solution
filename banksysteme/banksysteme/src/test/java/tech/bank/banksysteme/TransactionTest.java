package tech.bank.banksysteme;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tech.bank.banksysteme.model.CompteBancaire;
import tech.bank.banksysteme.model.Transaction;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class TransactionTest {

    private Transaction transaction;
    private CompteBancaire compteBancaire;

    @BeforeEach
    void setUp() {
        // Initialize CompteBancaire
        compteBancaire = new CompteBancaire();
        compteBancaire.setId(1L);
        compteBancaire.setType("Courant");
        compteBancaire.setSoldeInitial(1000.0);
        compteBancaire.setDateCreation(new Date());
        compteBancaire.setRaisonFermeture(null);
        compteBancaire.setActive(true);
        compteBancaire.setClosed(false);

        // Initialize Transaction
        transaction = new Transaction();
        transaction.setId(1L);
        transaction.setDateHeure(new Date());
        transaction.setMontant(100.0);
        transaction.setType("Débit");
        transaction.setDescription("Payment for Mohamed");
        transaction.setCompteBancaire(compteBancaire);
    }

    @Test
    void testTransactionEntity() {
        // Assert
        assertEquals(1L, transaction.getId());
        assertNotNull(transaction.getDateHeure());
        assertEquals(100.0, transaction.getMontant());
        assertEquals("Débit", transaction.getType());
        assertEquals("Payment for Mohamed", transaction.getDescription());

        // Assert compteBancaire association
        assertEquals(compteBancaire, transaction.getCompteBancaire());
    }
}
