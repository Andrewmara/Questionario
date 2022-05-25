package it.f2informatica.questionari.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.f2informatica.questionari.domain.RisposteUtente;
import it.f2informatica.questionari.service.risposteInterface;


@RestController
public class RisposteController {

	@Autowired()
	@Qualifier("MYSQL")
	risposteInterface risposteRepository;
	
	@RequestMapping(value="/risposteUtente", method=RequestMethod.POST)
	public ResponseEntity<String> addRisp(@RequestBody RisposteUtente newRisp) {
		if(this.risposteRepository.saveRisposte(newRisp)>0) {
			return new ResponseEntity<String>("Ok", HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<String>("KO", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	}
	
	@RequestMapping(value="/risposteUtente",method=RequestMethod.GET)
	public List<RisposteUtente> getRisp(){
		return this.risposteRepository.findAllRispo();
	}
	

}
