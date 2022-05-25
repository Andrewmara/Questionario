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

import it.f2informatica.questionari.service.domandaInterface;

@SpringBootTest
@AutoConfigureMockMvc
public class DomandeControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private domandaInterface domandeRepository;
	

	@Test
	public void getDomande() throws Exception {
		mockMvc.perform(get("/domande")).andDo(print()).andExpect(status().isOk());
	}

	
	@Test
	public void postDomanda() throws Exception {
		mockMvc.perform(post("/domande").content("{\"domanda\": \"domanda test\", \"questionario\":\"1\", \"risposta\":\"risposta test\"}")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated()).andReturn();
	}
	
}