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

import it.f2informatica.questionari.service.questionarioUtenteInterface;


@SpringBootTest
@AutoConfigureMockMvc
public class QuestionarioUtenteControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private questionarioUtenteInterface questRepository;
	

	@Test
	public void getQuestUtent() throws Exception {
		mockMvc.perform(get("/questionarioutente")).andDo(print()).andExpect(status().isOk());
	}

	
	@Test
	public void postQuestUtent() throws Exception {
	mockMvc.perform(post("/questionarioutente").content("{\"questionario\": \"3\", \"utente\":\"3\", \"punteggio\":\"20\"}")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated()).andReturn();
	}
	
	

	
}