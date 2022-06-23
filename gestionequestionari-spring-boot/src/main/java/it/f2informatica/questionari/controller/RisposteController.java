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
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import it.f2informatica.questionari.domain.RisposteUtente;
import it.f2informatica.questionari.service.risposteInterface;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class RisposteController {

	@Autowired()
	@Qualifier("MYSQL")
	risposteInterface risposteRepository;
	
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successo|OK"),
			@ApiResponse(code = 500, message = "internal server error"),
			@ApiResponse(code = 404, message = "NOT found") })
	
	@PostMapping(path="/risposteUtente")
	public ResponseEntity<String> addRisp(@RequestBody RisposteUtente newRisp) {
		if(this.risposteRepository.saveRisposte(newRisp)>0) {
			return new ResponseEntity<String>("Ok", HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<String>("KO", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	}
	
	@GetMapping(path="/risposteUtente")
	public List<RisposteUtente> getRisp(){
		return this.risposteRepository.findAllRispo();
	}
	@DeleteMapping(path="/deleteRisp/{id_questionario}/{id_utente}")
	public void deleteQuest(@PathVariable int id_questionario,@PathVariable int id_utente) {
		this.risposteRepository.deleteAllRispByQuestUtent(id_questionario, id_utente);
	 }

}
