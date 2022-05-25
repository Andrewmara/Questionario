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

import it.f2informatica.questionari.service.questionarioInterface;

@SpringBootTest
@AutoConfigureMockMvc
public class QuestionarioControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private questionarioInterface questionarioRepository;
	

	@Test
	public void getQuestionari() throws Exception {
		mockMvc.perform(get("/questionari")).andDo(print()).andExpect(status().isOk());
	}

	
	@Test
	public void postQuest() throws Exception {

		mockMvc.perform(post("/questionari").content("{\"titolo\": \"prova test\", \"descrizione\":\"test\", \"docente\":\"2\"}")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated()).andReturn();
	}
	
}