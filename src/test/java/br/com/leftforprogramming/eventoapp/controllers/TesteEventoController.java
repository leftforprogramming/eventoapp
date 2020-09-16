package br.com.leftforprogramming.eventoapp.controllers;

import com.google.gson.Gson;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import br.com.leftforprogramming.eventoapp.EventoappApplicationTests;

public class TesteEventoController extends EventoappApplicationTests {
    
    private MockMvc mockMvc;
    private Gson gson = new Gson();

    @Autowired
    private EventoController eventoController;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(eventoController).build();
    }

}