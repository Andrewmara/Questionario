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

import it.f2informatica.questionari.domain.Domande;
import it.f2informatica.questionari.domain.Utente;
import it.f2informatica.questionari.service.domandaInterface;

@RestController
public class DomandeController {

	@Autowired()
	@Qualifier("MYSQL")
	domandaInterface domandaRepository;
	
	@RequestMapping(value="/domande", method=RequestMethod.POST)
	public ResponseEntity<String> addDoma(@RequestBody Domande newDoma) {
		if(this.domandaRepository.saveDoma(newDoma)>0) {
			return new ResponseEntity<String>("Ok", HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<String>("KO", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	}
	
	@RequestMapping(value="/domande",method=RequestMethod.GET)
	public List<Domande> getDoma(){
		return this.domandaRepository.findAllDoma();
	}
	
	@RequestMapping(value="/domande/questionario/{id_quest}", method=RequestMethod.GET)
	public List<Domande> getDomandeIdQuest(@PathVariable int id_quest) {
		return this.domandaRepository.findAllDomaByQuestId(id_quest);


	}
	
	@RequestMapping(value="/domande/numero/{questionario}", method=RequestMethod.GET)
	public Integer getNumeroDomande(@PathVariable int questionario) {
		return this.domandaRepository.nDomande(questionario);
	}

	@RequestMapping(value="/domande/ptot/{questionario}", method=RequestMethod.GET)
	public Integer getPuntTot(@PathVariable int questionario) {
		return this.domandaRepository.Ptot(questionario);
	}
}
