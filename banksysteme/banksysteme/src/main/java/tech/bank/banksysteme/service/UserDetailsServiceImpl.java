package tech.bank.banksysteme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tech.bank.banksysteme.model.Utilisateur;
import tech.bank.banksysteme.repository.UtilisateurRepo;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UtilisateurRepo userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utilisateur user =userRepository.findUtilisateurByUsername(username);
        System.out.println(user.getUsername()+"///:::22IMPL/"+user.getPassword());
        return user.builder().username(user.getUsername()).password(user.getPassword()).build();

    }
}
