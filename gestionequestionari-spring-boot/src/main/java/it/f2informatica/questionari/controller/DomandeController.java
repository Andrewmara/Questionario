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
import it.f2informatica.questionari.domain.Domande;
import it.f2informatica.questionari.domain.Utente;
import it.f2informatica.questionari.service.domandaInterface;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class DomandeController {

	@Autowired()
	@Qualifier("MYSQL")
	domandaInterface domandaRepository;
	
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successo|OK"),
			@ApiResponse(code = 500, message = "internal server error"),
			@ApiResponse(code = 404, message = "NOT found") })
	
	@PostMapping(path="/domande")
	public ResponseEntity<String> addDoma(@RequestBody Domande newDoma) {
		if(this.domandaRepository.saveDoma(newDoma)>0) {
			return new ResponseEntity<String>("Ok", HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<String>("KO", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	}
	
	@GetMapping(path="/domande")
	public List<Domande> getDoma(){
		return this.domandaRepository.findAllDoma();
	}
	
	@GetMapping(path="/domande/questionario/{id_quest}")
	public List<Domande> getDomandeIdQuest(@PathVariable int id_quest) {
		return this.domandaRepository.findAllDomaByQuestId(id_quest);


	}
	
	@GetMapping(path="/domande/numero/{questionario}")
	public Integer getNumeroDomande(@PathVariable int questionario) {
		return this.domandaRepository.nDomande(questionario);
	}

	@GetMapping(path="/domande/ptot/{questionario}")
	public Integer getPuntTot(@PathVariable int questionario) {
		return this.domandaRepository.Ptot(questionario);
	}
}
