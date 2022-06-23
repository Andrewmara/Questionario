package it.f2informatica.questionari.service;

import java.util.List;
import java.util.Set;

import it.f2informatica.questionari.domain.Questionario;
import it.f2informatica.questionari.domain.Utente;


public interface questionarioInterface {
	
int saveQuest(Questionario q);
	
	List<Questionario> findAllQuest();

	List<Questionario> findQuestByDocente(Long docente);

	Integer idQuestionario(String titolo, String descrizione, Utente utente);

}
