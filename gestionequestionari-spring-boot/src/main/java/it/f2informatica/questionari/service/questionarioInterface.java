package it.f2informatica.questionari.service;

import java.util.List;
import java.util.Set;

import it.f2informatica.questionari.domain.Questionario;
import it.f2informatica.questionari.domain.Utente;


public interface questionarioInterface {
	
Long saveQuest(Questionario q);
	
	List<Questionario> findAllQuest();

	List<Questionario> findQuestByDocente(Long docente);

	Long idQuestionario(String titolo, String descrizione, Long utente);

}
