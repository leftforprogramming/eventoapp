package br.com.leftforprogramming.eventoapp;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.leftforprogramming.eventoapp.models.ConvidadoModel;
import br.com.leftforprogramming.eventoapp.models.EventoModel;
import br.com.leftforprogramming.eventoapp.repository.ConvidadoRepository;
import br.com.leftforprogramming.eventoapp.repository.EventoRepository;

@SpringBootApplication
public class EventoappApplication implements CommandLineRunner {

	@Autowired
	private EventoRepository eventoRepository;
	@Autowired
	private ConvidadoRepository convidadoRepository;
	public static void main(String[] args) {
		SpringApplication.run(EventoappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}