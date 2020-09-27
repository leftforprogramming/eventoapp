package br.com.leftforprogramming.eventoapp.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.leftforprogramming.eventoapp.models.ConvidadoModel;
import br.com.leftforprogramming.eventoapp.models.EventoModel;

public interface ConvidadoRepository extends CrudRepository<ConvidadoModel, String>{

	Iterable<ConvidadoModel> findByEvento(EventoModel evento);

}
