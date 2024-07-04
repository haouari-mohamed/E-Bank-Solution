package service;

import model.CompteBancaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CompteBancaireRepo;

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
                .orElseThrow(() -> new RuntimeException("Compte bancaire not found wth id: " + id));
    }

    public CompteBancaire createCompteBancaire(CompteBancaire compteBancaire) {
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
}