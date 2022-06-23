package it.f2informatica.questionari.controller;

import it.f2informatica.questionari.domain.Utente;
import it.f2informatica.questionari.repository.UserRepository;
import it.f2informatica.questionari.security.AuthenticationBean;
import it.f2informatica.questionari.security.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    UserRepository userRepository;

    @GetMapping(path = "/basicauth")
    public AuthenticationBean basicauth() {
        return new AuthenticationBean("You are logged in");
    }

    @GetMapping(path = "/basicauth/{email}")
    public String getUserRole(@PathVariable("email") String email) {
        Utente utente = this.userRepository.findByEmail(email);
        return utente.getRuolo().toString();
    }


}
