package it.f2informatica.questionari.service;

import java.util.List;


import it.f2informatica.questionari.domain.Questionario;
import it.f2informatica.questionari.domain.QuestionarioUtente;
import it.f2informatica.questionari.domain.Utente;



public interface questionarioUtenteInterface {
	
	int saveQU(QuestionarioUtente qu);
	
	List<QuestionarioUtente> findAllQU();
	
	Integer countCandidati(int questionario);

	Integer mediaPunteggi(int questionario);

	List<Utente> findUserOfQuest(int questionario);

	List<QuestionarioUtente> findQuestOfUser(int utente);

	Integer punteggioUtente(int utente, int questionario);

	List<Questionario> TitoloDescrizion(int utente);

	Integer QuestAlredyDone(int questionario, int utente);

	void deleteQuest(int questionario, int utente);


}
