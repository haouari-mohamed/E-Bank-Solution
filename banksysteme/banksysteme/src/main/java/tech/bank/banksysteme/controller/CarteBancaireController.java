package tech.bank.banksysteme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.bank.banksysteme.model.CarteBancaire;
import tech.bank.banksysteme.service.CarteBancaireService;

import java.util.List;

@RestController
@RequestMapping("/api/cartes-bancaires")
public class CarteBancaireController {

    @Autowired
    private CarteBancaireService carteBancaireService;

    @GetMapping
    public List<CarteBancaire> getAllCartesBancaires() {
        return carteBancaireService.getAllCartesBancaires();
    }

    @GetMapping("/{id}")
    public CarteBancaire getCarteBancaireById(@PathVariable Long id) {
        return carteBancaireService.getCarteBancaireById(id);
    }

    @PostMapping("/create")
    public CarteBancaire createCarteBancaire(@RequestBody CarteBancaire carteBancaire) {
        return carteBancaireService.createCarteBancaire(carteBancaire);
    }

    @PutMapping("/{id}/update")
    public CarteBancaire updateCarteBancaire(@PathVariable Long id, @RequestBody CarteBancaire carteBancaireDetails) {
        return carteBancaireService.updateCarteBancaire(id, carteBancaireDetails);
    }

    @DeleteMapping("/{id}/delete")
    public void deleteCarteBancaire(@PathVariable Long id) {
        carteBancaireService.deleteCarteBancaire(id);
    }

}
