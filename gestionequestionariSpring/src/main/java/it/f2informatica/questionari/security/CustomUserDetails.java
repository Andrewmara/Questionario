package it.f2informatica.questionari.security;

import it.f2informatica.questionari.domain.Utente;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;

@Component
public class CustomUserDetails implements UserDetails {

    private Utente utente;

    public CustomUserDetails(Utente utente) {
        super();
        this.utente = utente;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(utente.getRuolo()));
    }

    @Override
    public String getPassword() {
        return utente.getPassword();
    }

    @Override
    public String getUsername() {
        return null;
    }

    public String getEmail() {
        return utente.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
