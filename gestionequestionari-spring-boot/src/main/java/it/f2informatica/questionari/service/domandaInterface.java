package it.f2informatica.questionari.service;

import java.util.List;

import it.f2informatica.questionari.domain.Domande;



public interface domandaInterface {

    int saveDoma(Domande d);
	
	List<Domande> findAllDoma();
	
	List<Domande> findAllDomaByQuestId(int id);
	
	Integer nDomande(int questionario);

	Integer Ptot(int questionario);
	
	
}
