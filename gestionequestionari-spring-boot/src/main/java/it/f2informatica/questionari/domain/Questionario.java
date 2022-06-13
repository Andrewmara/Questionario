package it.f2informatica.questionari.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

@Repository
@Entity
@Table(name = "questionario")
public class Questionario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id_questionario;
	String titolo;
	String descrizione;
	int docente;

	public Questionario() {
	}

	public Questionario(String titolo, String descrizione, int docente, int id_questionario) {
		this.titolo = titolo;
		this.descrizione = descrizione;
		this.docente = docente;
		this.id_questionario = id_questionario;
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

	public int getDocente() {
		return docente;
	}

	public void setDocente(int docente) {
		this.docente = docente;
	}

	public int getId_questionario() {
		return id_questionario;
	}

	public void setId_questionario(int id_questionario) {
		this.id_questionario = id_questionario;
	}

	@Override
	public String toString() {
		return "Questionario [titolo=" + titolo + ", descrizione=" + descrizione + ", docente=" + docente
				+ ", id_questionario=" + id_questionario + "]";
	}

}
