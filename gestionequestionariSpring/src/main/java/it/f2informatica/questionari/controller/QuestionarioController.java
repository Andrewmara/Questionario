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
import it.f2informatica.questionari.service.questionarioInterface;





@RestController
public class QuestionarioController {

	@Autowired()
	@Qualifier("MYSQL")
	questionarioInterface questionarioRepository;
	
	@RequestMapping(value="/questionari", method=RequestMethod.POST)
	public int addQuest(@RequestBody Questionario newQuest) {
    this.questionarioRepository.saveQuest(newQuest);
    return this.questionarioRepository.idQuestionario(newQuest.getTitolo(), newQuest.getDescrizione(), newQuest.getDocente());
	}
	
	@RequestMapping(value="/questionari",method=RequestMethod.GET)
	public List<Questionario> getQuest(){
		return this.questionarioRepository.findAllQuest();
	}
	
	@RequestMapping(value="/questionari/{docente}",method=RequestMethod.GET)
	public List<Questionario> findQuestBydocente(@PathVariable int docente){
		return this.questionarioRepository.findQuestByDocente(docente);
	}
	
}
