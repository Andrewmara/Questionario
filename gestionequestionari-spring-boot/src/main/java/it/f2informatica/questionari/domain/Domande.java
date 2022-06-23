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
@Table(name = "domande")
public class Domande implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@Column(name="domanda")
	private String domanda;
	
	@Column(name="giusta")
	private String giusta;
	
	@Column(name="ris_uno")
	private String ris_uno;
	
	@Column(name="ris_due")
	private String ris_due;
	
	@Column(name="ris_tre")
	private String ris_tre;
	
	@Column(name="punteggio")
	private int punteggio;
	
	@JoinColumn(name = "id_questionario")
	@ManyToOne(targetEntity = Questionario.class, fetch = FetchType.LAZY)
	@NotNull(message = "Quest not set")
	@JsonIgnore
    private Questionario questionario;
	
	@Column(name = "id_questionario", insertable = false, updatable = false)
	private Long id_questionario;

	public Domande() {
	}

	public Domande(String domanda, String giusta, String ris_uno, String ris_due, String ris_tre, int punteggio) {
		super();
		this.domanda = domanda;
		this.giusta = giusta;
		this.ris_uno = ris_uno;
		this.ris_due = ris_due;
		this.ris_tre = ris_tre;
		this.punteggio = punteggio;
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDomanda() {
		return domanda;
	}

	public void setDomanda(String domanda) {
		this.domanda = domanda;
	}


	public String getGiusta() {
		return giusta;
	}

	public void setGiusta(String giusta) {
		this.giusta = giusta;
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

	public int getPunteggio() {
		return punteggio;
	}

	public void setPunteggio(int punteggio) {
		this.punteggio = punteggio;
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
		return "Domande [id=" + id + ", domanda=" + domanda + ", giusta=" + giusta + ", ris_uno=" + ris_uno
				+ ", ris_due=" + ris_due + ", ris_tre=" + ris_tre + ", punteggio=" + punteggio + ", id_questionario="
				+ id_questionario + "]";
	}



	



}
