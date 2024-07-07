package tech.bank.banksysteme;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tech.bank.banksysteme.model.CarteBancaire;
import tech.bank.banksysteme.model.CompteBancaire;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class CarteBancaireTest {

    private CarteBancaire carteBancaire;
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

        // Initialize CarteBancaire
        carteBancaire = new CarteBancaire();
        carteBancaire.setId(1L);
        carteBancaire.setNumero("1234567890123456");
        carteBancaire.setDateExpiration(new Date());
        carteBancaire.setType("Visa");
        carteBancaire.setRaisonBlocage(null);
        carteBancaire.setCompteBancaire(compteBancaire);
    }

    @Test
    void testCarteBancaireEntity() {
        // Assert
        assertEquals(1L, carteBancaire.getId());
        assertEquals("1234567890123456", carteBancaire.getNumero());
        assertNotNull(carteBancaire.getDateExpiration());
        assertEquals("Visa", carteBancaire.getType());
        assertNull(carteBancaire.getRaisonBlocage());

        // Assert compteBancaire association
        assertEquals(compteBancaire, carteBancaire.getCompteBancaire());
    }
}
