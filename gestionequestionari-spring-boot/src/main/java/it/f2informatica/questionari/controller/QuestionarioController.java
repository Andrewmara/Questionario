package it.f2informatica.questionari.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import it.f2informatica.questionari.service.questionarioInterface;

@CrossOrigin(origins = "http://192.168.1.230:4200")
@RestController
@RequestMapping("/api")
public class QuestionarioController {

	@Autowired()
	@Qualifier("MYSQL")
	questionarioInterface questionarioRepository;
	
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successo|OK"),
			@ApiResponse(code = 500, message = "internal server error"),
			@ApiResponse(code = 404, message = "NOT found") })
	
	@PostMapping(path="/questionari")
	public Long addQuest(@RequestBody Questionario newQuest) {
      this.questionarioRepository.saveQuest(newQuest);
      return this.questionarioRepository.idQuestionario(newQuest.getTitolo(), newQuest.getDescrizione(), newQuest.getId_utente());
	}
	
	
	@GetMapping(path="/questionari")
	public List<Questionario> getQuest(){
		return this.questionarioRepository.findAllQuest();
	}
	
	@GetMapping(path="/questionari/{id_utente}")
	public List<Questionario> findQuestBydocente(@PathVariable Long id_utente){
		return this.questionarioRepository.findQuestByDocente(id_utente);
	}
	
	
	
}
