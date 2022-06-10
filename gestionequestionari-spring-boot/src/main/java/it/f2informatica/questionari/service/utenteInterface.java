package it.f2informatica.questionari.service;

import java.util.List;

import it.f2informatica.questionari.domain.Utente;


public interface utenteInterface {
	
	int save(Utente u);
	
	List<Utente> findAll();

	Utente findById(int id_utente);

	Utente findByEmail2(String email);
	

}
