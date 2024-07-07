package tech.bank.banksysteme;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tech.bank.banksysteme.model.CompteBancaire;
import tech.bank.banksysteme.model.Utilisateur;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UtilisateurTest {

	private Utilisateur utilisateur;

	@BeforeEach
	void setUp() {
		utilisateur = new Utilisateur();
		utilisateur.setId(1L);
		utilisateur.setNom("mohamed");
		utilisateur.setEmail("mohamed@example.com");
		utilisateur.setMotDePasse("med12");

		// Initialize compteBancaires list
		List<CompteBancaire> compteBancaires = new ArrayList<>();
		CompteBancaire compte1 = new CompteBancaire();
		compte1.setId(1L);
		compte1.setSoldeInitial(1000.0);
		compte1.setType("Courant");
		compte1.setUtilisateur(utilisateur);

		CompteBancaire compte2 = new CompteBancaire();
		compte2.setId(2L);
		compte2.setSoldeInitial(2000.0);
		compte2.setType("Épargne");
		compte2.setUtilisateur(utilisateur);

		compteBancaires.add(compte1);
		compteBancaires.add(compte2);

		utilisateur.setCompteBancaires(compteBancaires);
	}

	@Test
	void testUtilisateurEntity() {
		// Assert
		assertEquals(1L, utilisateur.getId());
		assertEquals("mohamed", utilisateur.getNom());
		assertEquals("mohamed@example.com", utilisateur.getEmail());
		assertEquals("med12", utilisateur.getMotDePasse());

		// Assert compteBancaires list size and contents
		List<CompteBancaire> compteBancaires = utilisateur.getCompteBancaires();
		assertNotNull(compteBancaires);
		assertEquals(2, compteBancaires.size());

		CompteBancaire firstCompte = compteBancaires.get(0);
		assertEquals(1L, firstCompte.getId());
		assertEquals(1000.0, firstCompte.getSoldeInitial());
		assertEquals("Courant", firstCompte.getType());

		CompteBancaire secondCompte = compteBancaires.get(1);
		assertEquals(2L, secondCompte.getId());
		assertEquals(2000.0, secondCompte.getSoldeInitial());
		assertEquals("Épargne", secondCompte.getType());

		// Assert bidirectional relationship
		for (CompteBancaire compte : compteBancaires) {
			assertEquals(utilisateur, compte.getUtilisateur());
		}
	}
}
