package it.f2informatica.questionari.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Repository
@Data
@Entity
@Table(name = "utente")

public class Utente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="cognome")
	private String cognome;
	
	
	@JoinColumn(name = "ruolo")
	@ManyToOne(targetEntity = Ruolo.class, fetch = FetchType.LAZY)
	@NotNull(message = "ruolo not set")
	@JsonIgnore
	private Ruolo ruol;

	@Column(name = "ruolo", insertable = false, updatable = false)
	private String ruolo;
	
	@Column(name="password")
	private String password;
	
	@Column(name="email")
	private String email;
	
	
	
	public Utente() {
		super();
		
	}


	public Utente(String nome, String cognome, String password, String email) {
		this.nome = nome;
		this.cognome = cognome;
		this.password = password;
		this.email = email;
	}



	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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


	public Ruolo getRuol() {
		return ruol;
	}


	public void setRuol(Ruolo ruol) {
		this.ruol = ruol;
	}


	public String getRuolo() {
		return ruolo;
	}


	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}


	@Override
	public String toString() {
		return "Utente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", ruolo=" + ruolo + ", password="
				+ password + ", email=" + email + "]";
	}

}
