package service;

import model.Beneficiaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.BeneficaireRepo;

import java.util.List;


@Service
public class BeneficiaireService {

    @Autowired
    private BeneficaireRepo beneficaireRepo;

   public  List<Beneficiaire> getAllBeneficiaires(){
       return  beneficaireRepo.findAll();
   }
    public Beneficiaire getBeneficiaireById(Long id) {
        return beneficaireRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Beneficiaire not found with id: " + id));
    }
    public  Beneficiaire createBeneficiaire (Beneficiaire beneficiaire){
        return  beneficaireRepo.save(beneficiaire);

    }
    public Beneficiaire updateBeneficiaire(Long id, Beneficiaire beneficiaireDetails) {
        Beneficiaire bene = getBeneficiaireById(id);
        bene.setNom(beneficiaireDetails.getNom());
        bene.setNumeroCompte(beneficiaireDetails.getNumeroCompte());
        bene.setBanque(beneficiaireDetails.getBanque());
        return beneficaireRepo.save(bene);
    }


}
