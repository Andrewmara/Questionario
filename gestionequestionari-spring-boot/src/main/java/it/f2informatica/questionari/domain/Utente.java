package it.f2informatica.questionari.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

@Repository
@Entity
@Table(name = "utente")

public class Utente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id_utente;
	String nome;
	String cognome;
	String ruolo;
	String password;
	String email;

	public Utente() {
	}

	public Utente(int id_utente, String nome, String cognome, String ruolo, String password, String email) {
		this.id_utente = id_utente;
		this.nome = nome;
		this.cognome = cognome;
		this.ruolo = ruolo;
		this.password = password;
		this.email = email;
	}

	public int getId_utente() {
		return id_utente;
	}

	public void setId_utente(int id_utente) {
		this.id_utente = id_utente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Utente [id_utente=" + id_utente + ", password=" + password + ", nome=" + nome + ", email=" + email
				+ ", cognome=" + cognome + ", ruolo=" + ruolo + "]";
	}

}
