package it.f2informatica.questionari.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.f2informatica.questionari.domain.Questionario;
import it.f2informatica.questionari.domain.QuestionarioUtente;
import it.f2informatica.questionari.domain.Utente;
import it.f2informatica.questionari.service.questionarioUtenteInterface;



@RestController
public class QuestionarioUtenteController {

	@Autowired()
	@Qualifier("MYSQL")
	questionarioUtenteInterface quRepository;
	
	@RequestMapping(value="/questionarioutente", method=RequestMethod.POST)
	public ResponseEntity<String> addQuesUt(@RequestBody QuestionarioUtente newQU) {
		if(this.quRepository.saveQU(newQU)>0) {
			return new ResponseEntity<String>("Ok", HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<String>("KO", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	}
	
	@RequestMapping(value="/questionarioutente",method=RequestMethod.GET)
	public List<QuestionarioUtente> getUtente(){
		return this.quRepository.findAllQU();
	}
	
	@RequestMapping(value="/questionarioutente/{questionario}",method=RequestMethod.GET)
	public Integer countCandidati(@PathVariable int questionario){
		return this.quRepository.countCandidati(questionario);
	}
	
	@RequestMapping(value="/questionarioutente/media/{questionario}",method=RequestMethod.GET)
	public Integer mediaPunteggi(@PathVariable int questionario){
		return this.quRepository.mediaPunteggi(questionario);
	}
	
	@RequestMapping(value="/questionarioutente/user/{questionario}",method=RequestMethod.GET)
	public List<Utente> findUserOfQuest(@PathVariable int questionario){
		return this.quRepository.findUserOfQuest(questionario);
	}
	
	@RequestMapping(value="/questionarioutente/utente/{utente}",method=RequestMethod.GET)
	public List<QuestionarioUtente> findQuestofUser(@PathVariable int utente){
		return this.quRepository.findQuestOfUser(utente);
	}
	
	@RequestMapping(value="/punteggio/{utente}/{questionario}",method=RequestMethod.GET)
	public Integer punteggioUtente(@PathVariable int utente,@PathVariable int questionario){
		return this.quRepository.punteggioUtente(utente, questionario);
	}
	
	@RequestMapping(value="/questionarioutente/titolo/{utente}",method=RequestMethod.GET)
	public List<Questionario> TitoloDescrizione(@PathVariable int utente){
		return this.quRepository.TitoloDescrizion(utente);
	}
	
}
