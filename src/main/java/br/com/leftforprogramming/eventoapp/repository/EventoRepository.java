package br.com.leftforprogramming.eventoapp.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.leftforprogramming.eventoapp.models.EventoModel;

public interface EventoRepository extends CrudRepository<EventoModel, String>{

	EventoModel findById(long codigo);
    
}
