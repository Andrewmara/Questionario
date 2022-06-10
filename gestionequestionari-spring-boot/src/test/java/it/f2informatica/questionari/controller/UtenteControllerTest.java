package it.f2informatica.questionari.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import it.f2informatica.questionari.domain.Utente;
import it.f2informatica.questionari.service.utenteInterface;

@SpringBootTest
@AutoConfigureMockMvc
public class UtenteControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private utenteInterface utenteRepository;
	

	@Test
	public void getUtentiTest() throws Exception {
		mockMvc.perform(get("/utenti")).andDo(print()).andExpect(status().isOk());
	}


	
}