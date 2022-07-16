package ar.com.xcale.challenge.whatsapp;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import ar.com.xcale.challenge.whatsapp.controller.WhatsappGroupController;

@WebMvcTest(WhatsappGroupController.class)
class WhatsappApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private WhatsappGroupController service;

	@Test
	public void greetingShouldReturnMessageFromService() throws Exception {
		when(service.greet()).thenReturn("Hello, Mock");
		this.mockMvc.perform(get("/greet")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Hello, Mock")));
	}

	@Test
	public void sendMessageShouldReturnMessageFromService() throws Exception {
		this.mockMvc.perform(post("/message")
		.contentType(MediaType.APPLICATION_JSON)
		.param("userName", "Pablo")
		.param("message", "Hola como anda la banda"))
		.andExpect(status().isOk());
	}
}
