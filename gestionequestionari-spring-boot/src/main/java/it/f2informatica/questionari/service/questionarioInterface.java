package it.f2informatica.questionari.service;

import java.util.List;

import it.f2informatica.questionari.domain.Questionario;


public interface questionarioInterface {
	
int saveQuest(Questionario q);
	
	List<Questionario> findAllQuest();

	List<Questionario> findQuestByDocente(int docente);

	Integer idQuestionario(String titolo, String descrizione, int docente);

}
