package it.f2informatica.questionari.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import it.f2informatica.questionari.service.risposteInterface;



@SpringBootTest
@AutoConfigureMockMvc
public class RisposteUtenteControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private risposteInterface risposteRepository;
	

	@Test
	public void getRisposteUtente() throws Exception {
		mockMvc.perform(get("/risposteUtente")).andDo(print()).andExpect(status().isOk());
	}


	

	
}