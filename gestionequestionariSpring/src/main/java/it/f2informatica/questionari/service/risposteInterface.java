package it.f2informatica.questionari.service;

import java.util.List;

import it.f2informatica.questionari.domain.RisposteUtente;


public interface risposteInterface {

	int saveRisposte(RisposteUtente r);
	
	List<RisposteUtente> findAllRispo();

}
