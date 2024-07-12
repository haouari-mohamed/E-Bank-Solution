package tech.bank.banksysteme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import tech.bank.banksysteme.model.Utilisateur;
import tech.bank.banksysteme.security.JwtAuth;
import tech.bank.banksysteme.service.UtilisateurService;

import java.util.List;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;
    @Autowired
    AuthenticationManager authenticationManager;

    @GetMapping
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurService.getAllUtilisateurs();
    }

    @GetMapping("/{id}")
    public Utilisateur getUtilisateurById(@PathVariable Long id) {
        return utilisateurService.getUtilisateurById(id);
    }

    @PostMapping("/create")
    public Utilisateur createUtilisateur(@RequestBody Utilisateur utilisateur) {
        return utilisateurService.createUtilisateur(utilisateur);
    }

    @PutMapping("/{id}/update")
    public Utilisateur updateUtilisateur(@PathVariable Long id, @RequestBody Utilisateur utilisateurDetails) {
        return utilisateurService.updateUtilisateur(id, utilisateurDetails);
    }

    @DeleteMapping("/{id}/delete")
    public void deleteUtilisateur(@PathVariable Long id) {
        utilisateurService.deleteUtilisateur(id);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Utilisateur user) {
        System.out.println("///////////////////"+user.getPassword()+"//////////////"+user.getUsername());
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
        );
        String token = JwtAuth.generateToken(user.getUsername());
        return ResponseEntity.ok(token);

    }
    
}
