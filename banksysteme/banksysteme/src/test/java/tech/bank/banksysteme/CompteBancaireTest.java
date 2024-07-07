package tech.bank.banksysteme;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tech.bank.banksysteme.model.CompteBancaire;
import tech.bank.banksysteme.model.Utilisateur;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CompteBancaireTest {

    private CompteBancaire compteBancaire;
    private Utilisateur utilisateur;

    @BeforeEach
    void setUp() {
        // Initialize Utilisateur
        utilisateur = new Utilisateur();
        utilisateur.setId(1L);
        utilisateur.setNom("mohamed");
        utilisateur.setEmail("mohamed@example.com");
        utilisateur.setMotDePasse("mohamed");

        // Initialize CompteBancaire
        compteBancaire = new CompteBancaire();
        compteBancaire.setId(1L);
        compteBancaire.setType("Courant");
        compteBancaire.setSoldeInitial(1300.0);
        compteBancaire.setDateCreation(new Date());
        compteBancaire.setRaisonFermeture(null);
        compteBancaire.setActive(true);
        compteBancaire.setClosed(false);
        compteBancaire.setUtilisateur(utilisateur);

        // Initialize lists (empty for now)
        compteBancaire.setTransactions(new ArrayList<>());
        compteBancaire.setCartesBancaires(new ArrayList<>());
        compteBancaire.setTransferts(new ArrayList<>());
    }

    @Test
    void testCompteBancaireEntity() {
        // Assert
        assertEquals(1L, compteBancaire.getId());
        assertEquals("Courant", compteBancaire.getType());
        assertEquals(1300.0, compteBancaire.getSoldeInitial());
        assertNotNull(compteBancaire.getDateCreation());
        assertNull(compteBancaire.getRaisonFermeture());
        assertTrue(compteBancaire.isActive());
        assertFalse(compteBancaire.isClosed());

        // Assert utilisateur association
        assertEquals(utilisateur, compteBancaire.getUtilisateur());

        // Assert empty lists
        assertTrue(compteBancaire.getTransactions().isEmpty());
        assertTrue(compteBancaire.getCartesBancaires().isEmpty());
        assertTrue(compteBancaire.getTransferts().isEmpty());
    }
}
