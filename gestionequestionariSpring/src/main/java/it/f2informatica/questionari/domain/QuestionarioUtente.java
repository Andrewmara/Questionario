package it.f2informatica.questionari.domain;

public class QuestionarioUtente {
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
