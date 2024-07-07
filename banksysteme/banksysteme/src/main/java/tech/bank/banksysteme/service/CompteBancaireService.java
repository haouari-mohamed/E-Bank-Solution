package tech.bank.banksysteme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.bank.banksysteme.model.CompteBancaire;
import tech.bank.banksysteme.repository.CompteBancaireRepo;

import java.util.List;

@Service
public class CompteBancaireService {

    @Autowired
    private CompteBancaireRepo compteBancaireRepo;

    public List<CompteBancaire> getAllComptesBancaires() {
        return compteBancaireRepo.findAll();
    }

    public CompteBancaire getCompteBancaireById(Long id) {
        return compteBancaireRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Compte bancaire not found with id: " + id));
    }

    public CompteBancaire createCompteBancaire(CompteBancaire compteBancaire) {
        compteBancaire.setActive(true);
        compteBancaire.setClosed(false);
        return compteBancaireRepo.save(compteBancaire);
    }

    public CompteBancaire updateCompteBancaire(Long id, CompteBancaire compteBancaireDetails) {
        CompteBancaire compteBancaire = getCompteBancaireById(id);
        compteBancaire.setType(compteBancaireDetails.getType());
        compteBancaire.setSoldeInitial(compteBancaireDetails.getSoldeInitial());
        compteBancaire.setDateCreation(compteBancaireDetails.getDateCreation());
        compteBancaire.setRaisonFermeture(compteBancaireDetails.getRaisonFermeture());
        return compteBancaireRepo.save(compteBancaire);
    }

    public void deleteCompteBancaire(Long id) {
        compteBancaireRepo.deleteById(id);
    }

    public CompteBancaire activateCompte(Long id) {
        CompteBancaire compteBancaire = getCompteBancaireById(id);
        if (!compteBancaire.isClosed()) {
            compteBancaire.setActive(true);
        }
        return compteBancaireRepo.save(compteBancaire);
    }

    public CompteBancaire deactivateCompte(Long id) {
        CompteBancaire compteBancaire = getCompteBancaireById(id);
        if (!compteBancaire.isClosed()) {
            compteBancaire.setActive(false);
        }
        return compteBancaireRepo.save(compteBancaire);
    }

    public CompteBancaire fermerCompte(Long id, String raison) {
        CompteBancaire compteBancaire = getCompteBancaireById(id);
        compteBancaire.setRaisonFermeture(raison);
        compteBancaire.setClosed(true);
        compteBancaire.setActive(false);
        return compteBancaireRepo.save(compteBancaire);
    }
}
