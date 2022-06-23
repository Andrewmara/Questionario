package it.f2informatica.questionari.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import it.f2informatica.questionari.domain.Questionario;
import it.f2informatica.questionari.domain.QuestionarioUtente;
import it.f2informatica.questionari.domain.Utente;
import it.f2informatica.questionari.service.questionarioUtenteInterface;

@CrossOrigin(origins = "http://192.168.1.230:4200")
@RestController
@RequestMapping("/api")
public class QuestionarioUtenteController {

	@Autowired()
	@Qualifier("MYSQL")
	questionarioUtenteInterface quRepository;
	
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successo|OK"),
			@ApiResponse(code = 500, message = "internal server error"),
			@ApiResponse(code = 404, message = "NOT found") })
	
	@PostMapping(path="/questionarioutente")
	public ResponseEntity<String> addQuesUt(@RequestBody QuestionarioUtente newQU) {
		if(this.quRepository.saveQU(newQU)>0) {
			return new ResponseEntity<String>("Ok", HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<String>("KO", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	}
	
	@GetMapping(path="/questionarioutente")
	public List<QuestionarioUtente> getUtente(){
		return this.quRepository.findAllQU();
	}
	
	@GetMapping(path="/questionarioutente/{questionario}")
	public Integer countCandidati(@PathVariable int questionario){
		return this.quRepository.countCandidati(questionario);
	}
	
	@GetMapping(path="/questionarioutente/media/{questionario}")
	public Integer mediaPunteggi(@PathVariable int questionario){
		return this.quRepository.mediaPunteggi(questionario);
	}
	
	@GetMapping(path="/questionarioutente/user/{questionario}")
	public List<Utente> findUserOfQuest(@PathVariable int questionario){
		return this.quRepository.findUserOfQuest(questionario);
	}
	
	@GetMapping(path="/questionarioutente/utente/{utente}")
	public List<QuestionarioUtente> findQuestofUser(@PathVariable int utente){
		return this.quRepository.findQuestOfUser(utente);
	}
	
	@GetMapping(path="/punteggio/{utente}/{questionario}")
	public Integer punteggioUtente(@PathVariable int utente,@PathVariable int questionario){
		return this.quRepository.punteggioUtente(utente, questionario);
	}
	
	@GetMapping(path="/questionarioutente/titolo/{utente}")
	public List<Questionario> TitoloDescrizione(@PathVariable int utente){
		return this.quRepository.TitoloDescrizion(utente);
	}
	

	@GetMapping(path="/questionarioutente/alreadyDone/{questionario}/{utente}")
	public Integer QuestAlreadyDone(@PathVariable int questionario,@PathVariable int utente){
		return this.quRepository.QuestAlredyDone(questionario, utente);
	}
	
	@DeleteMapping(path="/questionarioutente/delete/{questionario}/{utente}")
	public void deleteQuest(@PathVariable int questionario,@PathVariable int utente) {
		this.quRepository.deleteQuest(questionario, utente);
	 }
}
