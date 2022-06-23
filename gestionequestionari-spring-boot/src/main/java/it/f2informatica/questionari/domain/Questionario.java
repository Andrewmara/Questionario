package it.f2informatica.questionari.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Repository
@Data
@Entity
@Table(name = "questionario")
public class Questionario implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	
	@Column(name="titolo")
	private String titolo;
	
	@Column(name="descrizione")
	private String descrizione;
	
	
	
	
	@JoinColumn(name = "id_utente")
	@ManyToOne(targetEntity = Utente.class, fetch = FetchType.LAZY)
	@NotNull(message = "Utente not set")
	@JsonIgnore
	private Utente utente;

	@Column(name = "id_utente", insertable = false, updatable = false)
	private Long id_utente;
	
	

	public Questionario() {
		super();
	}

	
	public Questionario(String titolo, String descrizione) {
		this.titolo = titolo;
		this.descrizione = descrizione;
	}



	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getId_utente() {
		return id_utente;
	}


	public void setId_utente(Long id_utente) {
		this.id_utente = id_utente;
	}


	public Utente getUtente() {
		return utente;
	}


	public void setUtente(Utente utente) {
		this.utente = utente;
	}


	@Override
	public String toString() {
		return "Questionario [id=" + id + ", titolo=" + titolo + ", descrizione=" + descrizione + ", id_utente="
				+ id_utente + "]";
	}


	

}
