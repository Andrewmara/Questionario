package it.f2informatica.questionari.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

@Repository
@Entity
@Table(name = "domande")
public class Domande {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id_domanda;
	String domanda;
	int questionario;
	String ris_giusta;
	String ris_uno;
	String ris_due;
	String ris_tre;
	int punteggio;

	public Domande() {
	}

	public Domande(String domanda, int questionario, int id_domanda, String ris_giusta, String ris_uno, String ris_due,
			String ris_tre, int punteggio) {
		this.domanda = domanda;
		this.questionario = questionario;
		this.id_domanda = id_domanda;
		this.ris_giusta = ris_giusta;
		this.ris_uno = ris_uno;
		this.ris_due = ris_due;
		this.ris_tre = ris_tre;
		this.punteggio = punteggio;
	}

	public String getDomanda() {
		return domanda;
	}

	public int getPunteggio() {
		return punteggio;
	}

	public void setPunteggio(int punteggio) {
		this.punteggio = punteggio;
	}

	public void setDomanda(String domanda) {
		this.domanda = domanda;
	}

	public int getQuestionario() {
		return questionario;
	}

	public void setQuestionario(int questionario) {
		this.questionario = questionario;
	}

	public int getId_domanda() {
		return id_domanda;
	}

	public void setId_domanda(int id_domanda) {
		this.id_domanda = id_domanda;
	}

	public String getRis_giusta() {
		return ris_giusta;
	}

	public void setRis_giusta(String ris_giusta) {
		this.ris_giusta = ris_giusta;
	}

	public String getRis_uno() {
		return ris_uno;
	}

	public void setRis_uno(String ris_uno) {
		this.ris_uno = ris_uno;
	}

	public String getRis_due() {
		return ris_due;
	}

	public void setRis_due(String ris_due) {
		this.ris_due = ris_due;
	}

	public String getRis_tre() {
		return ris_tre;
	}

	public void setRis_tre(String ris_tre) {
		this.ris_tre = ris_tre;
	}

	@Override
	public String toString() {
		return "Domande [domanda=" + domanda + ", questionario=" + questionario + ", ris_giusta=" + ris_giusta
				+ " , ris_uno=" + ris_uno + " , ris_due=" + ris_due + " , ris_tre=" + ris_tre + ", id_domanda="
				+ id_domanda + "]";
	}

}
