package br.com.leftforprogramming.eventoapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.leftforprogramming.eventoapp.models.EventoModel;
import br.com.leftforprogramming.eventoapp.repository.EventoRepository;

@Controller
public class EventoController {

    @Autowired
    private EventoRepository eventoRepository;

    @RequestMapping(value="/cadastrarEvento", method = RequestMethod.GET)
    public String form(){
        return "evento/formEvento";
    }

    @RequestMapping(value="/cadastrarEvento", method = RequestMethod.POST)
    public String form(EventoModel evento){
        this.eventoRepository.save(evento);
        return "redirect:/cadastrarEvento";
    }
}