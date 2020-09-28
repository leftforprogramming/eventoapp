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
		EventoModel evento = new EventoModel("CES 2020","São Paulo","03/06/2020","15:00");

		this.eventoRepository.saveAll(Arrays.asList(evento));

		ConvidadoModel convidado = new ConvidadoModel("123", "Marcos");
		
		this.convidadoRepository.save(convidado);
		
		convidado.setEvento(evento);
		evento.setConvidados(Arrays.asList(convidado));

		this.eventoRepository.saveAll(Arrays.asList(evento));
		this.convidadoRepository.save(convidado);
	}
}
