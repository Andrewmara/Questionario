package it.f2informatica.questionari.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "questionario_utente")
public class QuestionarioUtente implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@JoinColumn(name = "id_utente")
	@ManyToOne(targetEntity = Utente.class, fetch = FetchType.LAZY)
	@NotNull(message = "Utente not set")
	@JsonIgnore
	private Utente utente;

	@Column(name = "id_utente", insertable = false, updatable = false)
	private Long id_utente;

	@Id
	@JoinColumn(name = "id_questionario")
	@ManyToOne(targetEntity = Questionario.class, fetch = FetchType.LAZY)
	@NotNull(message = "Quest not set")
	@JsonIgnore
    private Questionario questionario;
	
	@Column(name = "id_questionario", insertable = false, updatable = false)
	private Long id_questionario;
	

	@Column(name="punteggio")
	int punteggio;

	public 	QuestionarioUtente() {
	}

	public QuestionarioUtente(int punteggio) {
		this.punteggio = punteggio;
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

	public int getPunteggio() {
		return punteggio;
	}

	public void setPunteggio(int punteggio) {
		this.punteggio = punteggio;
	}

	@Override
	public String toString() {
		return "QuestionarioUtente [id_utente=" + id_utente + ", id_questionario=" + id_questionario + ", punteggio="
				+ punteggio + "]";
	}

	
}