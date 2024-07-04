package service;

import model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UtilisateurRepo;

import java.util.List;
@Service
public class UtilisateurService {
    @Autowired
    private UtilisateurRepo utilisateurRepo;

    public List<Utilisateur> getAllUtlisateurs(){
        return  utilisateurRepo.findAll();
    }
    public Utilisateur getUtilisateurById(Long id) {
        return utilisateurRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur not found with id : " + id));
    }
    public  Utilisateur createUtilisateur (Utilisateur utilisateur){
        return utilisateurRepo.save(utilisateur);
    }
    public Utilisateur updateUtilisateur (Long id , Utilisateur utilisateurDetails){
        Utilisateur utilisateur = getUtilisateurById(id);
        utilisateur.setNom(utilisateurDetails.getNom());
        utilisateur.setEmail(utilisateurDetails.getEmail());
        utilisateur.setMotDePasse(utilisateurDetails.getMotDePasse());
        return utilisateurRepo.save(utilisateur);

    }
    public void deleteUtilisateur(Long id){
        utilisateurRepo.deleteById(id);
    }

}
