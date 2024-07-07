package tech.bank.banksysteme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.bank.banksysteme.model.Beneficiaire;
import tech.bank.banksysteme.service.BeneficiaireService;

import java.util.List;

@RestController
@RequestMapping("/api/beneficiaires")
public class BeneficiaireController {

    @Autowired
    private BeneficiaireService beneficiaireService;

    @GetMapping
    public List<Beneficiaire> getAllBeneficiaires() {
        return beneficiaireService.getAllBeneficiaires();
    }

    @GetMapping("/{id}")
    public Beneficiaire getBeneficiaireById(@PathVariable Long id) {
        return beneficiaireService.getBeneficiaireById(id);
    }

    @PostMapping("/create")
    public Beneficiaire createBeneficiaire(@RequestBody Beneficiaire beneficiaire) {
        return beneficiaireService.createBeneficiaire(beneficiaire);
    }

    @PutMapping("/{id}/update")
    public Beneficiaire updateBeneficiaire(@PathVariable Long id, @RequestBody Beneficiaire beneficiaireDetails) {
        return beneficiaireService.updateBeneficiaire(id, beneficiaireDetails);
    }

    @DeleteMapping("/{id}/delete")
    public void deleteBeneficiaire(@PathVariable Long id) {
        beneficiaireService.deleteBeneficiaire(id);
    }


}
