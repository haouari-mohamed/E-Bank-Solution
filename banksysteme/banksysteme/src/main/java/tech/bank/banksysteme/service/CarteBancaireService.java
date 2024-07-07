package tech.bank.banksysteme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.bank.banksysteme.model.CarteBancaire;
import tech.bank.banksysteme.repository.CarteBancaireRepo;

import java.util.List;

@Service
public class CarteBancaireService {

    @Autowired
    private CarteBancaireRepo carteBancaireRepo;

    public List<CarteBancaire> getAllCartesBancaires() {
        return carteBancaireRepo.findAll();
    }

    public CarteBancaire getCarteBancaireById(Long id) {
        return carteBancaireRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Carte bancaire not found with id: " + id));
    }

    public CarteBancaire createCarteBancaire(CarteBancaire carteBancaire) {
        return carteBancaireRepo.save(carteBancaire);
    }

    public CarteBancaire updateCarteBancaire(Long id, CarteBancaire carteBancaireDetails) {
        CarteBancaire carteBancaire = getCarteBancaireById(id);
        carteBancaire.setNumero(carteBancaireDetails.getNumero());
        carteBancaire.setDateExpiration(carteBancaireDetails.getDateExpiration());
        carteBancaire.setType(carteBancaireDetails.getType());
        carteBancaire.setRaisonBlocage(carteBancaireDetails.getRaisonBlocage());
        return carteBancaireRepo.save(carteBancaire);
    }

    public void deleteCarteBancaire(Long id) {
        carteBancaireRepo.deleteById(id);
    }
}
