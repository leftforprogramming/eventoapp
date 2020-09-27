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
	public static void main(String[] args) {
		SpringApplication.run(EventoappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		EventoModel eventoCES = new EventoModel("CES 2020","São Paulo","03/06/2020","15:00");
		EventoModel eventoComix = new EventoModel("Comix 2020","Salvador","03/07/2020","15:30");
		EventoModel eventoRockInRio = new EventoModel("Rock in Rio 2020","Rio de Janeiro","03/08/2020","16:00");

		this.eventoRepository.saveAll(Arrays.asList(eventoCES, eventoComix, eventoRockInRio));
	}
}
