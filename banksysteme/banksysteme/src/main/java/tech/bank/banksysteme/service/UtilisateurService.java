package tech.bank.banksysteme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tech.bank.banksysteme.model.Utilisateur;
import tech.bank.banksysteme.repository.UtilisateurRepo;

import java.util.List;

@Service
public class UtilisateurService {
    @Autowired
    private UtilisateurRepo utilisateurRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepo.findAll();
    }

    public Utilisateur getUtilisateurById(Long id) {
        return utilisateurRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur not found with id : " + id));
    }

    public Utilisateur createUtilisateur(Utilisateur utilisateur) {
        String hashedPassword = passwordEncoder.encode(utilisateur.getPassword());
        utilisateur.setPassword(hashedPassword);

        return utilisateurRepo.save(utilisateur);
    }

    public Utilisateur updateUtilisateur(Long id, Utilisateur utilisateurDetails) {
        Utilisateur utilisateur = getUtilisateurById(id);
        utilisateur.setUsername(utilisateurDetails.getUsername());
        utilisateur.setEmail(utilisateurDetails.getEmail());
        utilisateur.setPassword(utilisateurDetails.getPassword());
        return utilisateurRepo.save(utilisateur);
    }

    public void deleteUtilisateur(Long id) {
        utilisateurRepo.deleteById(id);
    }
}
