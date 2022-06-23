package it.f2informatica.questionari.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Repository
@Data
@Entity
@Table(name = "risposte_utente")
public class RisposteUtente implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@JoinColumn(name = "id")
	@OneToOne(targetEntity = Domande.class, fetch = FetchType.LAZY)
	@NotNull(message = "Domande not set")
	@JsonIgnore
	private Domande domande;

	@Column(name = "id", insertable = false, updatable = false)
	private Long id;
	
	@Id
	@JoinColumn(name = "id_utente")
	@ManyToOne(targetEntity = Utente.class, fetch = FetchType.LAZY)
	@NotNull(message = "Utente not set")
	@JsonIgnore
	private Utente utente;

	@Column(name = "id_utente", insertable = false, updatable = false)
	private Long id_utente;

	@Column(name = "risposta")
	private String risposta;
	
	@Id
	@JoinColumn(name = "id_questionario")
	@ManyToOne(targetEntity = Questionario.class, fetch = FetchType.LAZY)
	@NotNull(message = "Quest not set")
	@JsonIgnore
    private Questionario questionario;
	
	@Column(name = "id_questionario", insertable = false, updatable = false)
	private Long id_questionario;

	public RisposteUtente() {
		
	}
	public RisposteUtente(String risposta) {
		super();
		this.risposta = risposta;
	}
	public Domande getDomande() {
		return domande;
	}
	public void setDomande(Domande domande) {
		this.domande = domande;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Utente getUtente() {
		return utente;
	}
	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	public Long getId_utente() {
		return id_utente;
	}
	public void setId_utente(Long id_utente) {
		this.id_utente = id_utente;
	}
	public String getRisposta() {
		return risposta;
	}
	public void setRisposta(String risposta) {
		this.risposta = risposta;
	}
	public Questionario getQuestionario() {
		return questionario;
	}
	public void setQuestionario(Questionario questionario) {
		this.questionario = questionario;
	}
	public Long getId_questionario() {
		return id_questionario;
	}
	public void setId_questionario(Long id_questionario) {
		this.id_questionario = id_questionario;
	}
	@Override
	public String toString() {
		return "RisposteUtente [id=" + id + ", id_utente=" + id_utente + ", risposta=" + risposta + ", id_questionario="
				+ id_questionario + "]";
	}
	
	
}
