package it.f2informatica.questionari.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

@Repository
@Entity
@Table(name = "questionario_utente")
public class QuestionarioUtente {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int questionario;
	int utente;
	int punteggio;

	public int getQuestionario() {
		return questionario;
	}

	public void setQuestionario(int questionario) {
		this.questionario = questionario;
	}

	public int getUtente() {
		return utente;
	}

	public void setUtente(int utente) {
		this.utente = utente;
	}

	public int getPunteggio() {
		return punteggio;
	}

	public void setPunteggio(int punteggio) {
		this.punteggio = punteggio;
	}

	@Override
	public String toString() {
		return "QuestionarioUtente [questionario=" + questionario + ", utente=" + utente + ", punteggio=" + punteggio
				+ "]";
	}

}
