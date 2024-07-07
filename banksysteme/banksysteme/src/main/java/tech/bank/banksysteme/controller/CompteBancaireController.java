package tech.bank.banksysteme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.bank.banksysteme.model.CompteBancaire;

import tech.bank.banksysteme.service.CompteBancaireService;


import java.util.List;

@RestController
@RequestMapping("/api/comptes-bancaires")
public class CompteBancaireController {

    @Autowired
    private CompteBancaireService compteBancaireService;

    @GetMapping
    public List<CompteBancaire> getAllComptesBancaires() {
        return compteBancaireService.getAllComptesBancaires();
    }

    @GetMapping("/{id}")
    public CompteBancaire getCompteBancaireById(@PathVariable Long id) {
        return compteBancaireService.getCompteBancaireById(id);
    }

    @PostMapping("/create")
    public CompteBancaire createCompteBancaire(@RequestBody CompteBancaire compteBancaire) {
        return compteBancaireService.createCompteBancaire(compteBancaire);
    }

    @PutMapping("/{id}/update")
    public CompteBancaire updateCompteBancaire(@PathVariable Long id, @RequestBody CompteBancaire compteBancaireDetails) {
        return compteBancaireService.updateCompteBancaire(id, compteBancaireDetails);
    }

    @DeleteMapping("/{id}/delete")
    public void deleteCompteBancaire(@PathVariable Long id) {
        compteBancaireService.deleteCompteBancaire(id);
    }


}
