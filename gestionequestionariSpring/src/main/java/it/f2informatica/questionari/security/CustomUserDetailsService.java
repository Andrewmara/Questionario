package it.f2informatica.questionari.security;

import it.f2informatica.questionari.domain.Utente;
import it.f2informatica.questionari.exception.UserNotFoundException;
import it.f2informatica.questionari.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    // Load user by email instead
        Utente utente = userRepository.findByEmail(email);
        if (utente == null) {
            throw new UserNotFoundException("Bad credentials");
        }
        return new CustomUserDetails(utente);
    }
}

