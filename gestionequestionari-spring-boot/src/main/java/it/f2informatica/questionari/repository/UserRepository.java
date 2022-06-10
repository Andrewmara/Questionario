package it.f2informatica.questionari.repository;

import it.f2informatica.questionari.domain.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Utente, Integer> {

    Utente findByEmail(String email);
}
