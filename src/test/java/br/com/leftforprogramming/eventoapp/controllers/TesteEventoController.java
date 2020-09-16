package br.com.leftforprogramming.eventoapp.controllers;

import com.google.gson.Gson;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import br.com.leftforprogramming.eventoapp.EventoappApplicationTests;
import br.com.leftforprogramming.eventoapp.models.EventoModel;

public class TesteEventoController extends EventoappApplicationTests {
    
    private MockMvc mockMvc;
    private Gson gson = new Gson();

    @Autowired
    private EventoController eventoController;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(eventoController).build();
    }

    @Test
	public void cadastrarEvento() throws Exception {
        EventoModel evento = new EventoModel();
        evento.setNome("TESTE");
        evento.setLocal("TESTE");
        evento.setData("09/09/2020");
        evento.setHorario("1212");
		this.mockMvc
            .perform(MockMvcRequestBuilders.post("")
            .contentType(MediaType.APPLICATION_JSON)
            .content(this.gson.toJson(evento)))
            .andExpect(MockMvcResultMatchers.status().isCreated());
	}

}