package it.f2informatica.questionari.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
import it.f2informatica.questionari.domain.Utente;
import it.f2informatica.questionari.service.utenteInterface;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UtenteController {
	
	
	@Autowired()
	@Qualifier("MYSQL")
	utenteInterface utenteRepositery;
	
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successo|OK"),
			@ApiResponse(code = 500, message = "internal server error"),
			@ApiResponse(code = 404, message = "NOT found") })
	
	@PostMapping(path="/utenti")
	public ResponseEntity<String> addUtente(@RequestBody Utente newUtente) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String password = newUtente.getPassword();
		String encodedPassword = passwordEncoder.encode(password);
		newUtente.setPassword(encodedPassword);

		if(this.utenteRepositery.save(newUtente)>0) {
			return new ResponseEntity<String>("Ok", HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<String>("KO", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	}
	
	@GetMapping(path="/utenti")
	public List<Utente> getUtente(){
		return this.utenteRepositery.findAll();
	}
	
	@GetMapping(path="/utenti/{id_utente}")
	public ResponseEntity<Utente> getUtenteByid(@PathVariable int id_utente) {
		Utente u =this.utenteRepositery.findById(id_utente);
		if(u!=null) {
		return new ResponseEntity<Utente>(u,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Utente>(u,HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(path="/utenti/email/{email}")
	public Utente findByEmail2(@PathVariable String email) {
		return this.utenteRepositery.findByEmail2(email);
	}
	
	
	
	

}
