package it.f2informatica.questionari.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

@Repository
@Entity
@Table(name = "risposte_utente")
public class RisposteUtente {
	int domanda;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	String risposta;
	int id_utente;

	public int getDomanda() {
		return domanda;
	}

	public void setDomanda(int domanda) {
		this.domanda = domanda;
	}

	public String getRisposta() {
		return risposta;
	}

	public void setRisposta(String risposta) {
		this.risposta = risposta;
	}

	public int getId_utente() {
		return id_utente;
	}

	public void setId_utente(int id_utente) {
		this.id_utente = id_utente;
	}

	@Override
	public String toString() {
		return "RisposteUtente [domanda=" + domanda + ", risposta=" + risposta + ", id_utente=" + id_utente + "]";
	}

}
