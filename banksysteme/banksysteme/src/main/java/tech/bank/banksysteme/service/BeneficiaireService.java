package tech.bank.banksysteme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.bank.banksysteme.model.Beneficiaire;
import tech.bank.banksysteme.repository.BeneficaireRepo;

import java.util.List;

@Service
public class BeneficiaireService {

    @Autowired
    private BeneficaireRepo beneficaireRepo;

    public List<Beneficiaire> getAllBeneficiaires() {
        return beneficaireRepo.findAll();
    }

    public Beneficiaire getBeneficiaireById(Long id) {
        return beneficaireRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Beneficiaire not found with id: " + id));
    }

    public Beneficiaire createBeneficiaire(Beneficiaire beneficiaire) {
        return beneficaireRepo.save(beneficiaire);
    }

    public Beneficiaire updateBeneficiaire(Long id, Beneficiaire beneficiaireDetails) {
        Beneficiaire beneficiaire = getBeneficiaireById(id);
        beneficiaire.setNom(beneficiaireDetails.getNom());
        beneficiaire.setId(beneficiaireDetails.getId());
        return beneficaireRepo.save(beneficiaire);
    }

    public void deleteBeneficiaire(Long id) {
        beneficaireRepo.deleteById(id);
    }
}
