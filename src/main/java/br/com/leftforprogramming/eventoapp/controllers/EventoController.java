package br.com.leftforprogramming.eventoapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.leftforprogramming.eventoapp.models.ConvidadoModel;
import br.com.leftforprogramming.eventoapp.models.EventoModel;
import br.com.leftforprogramming.eventoapp.repository.ConvidadoRepository;
import br.com.leftforprogramming.eventoapp.repository.EventoRepository;

@Controller
public class EventoController {

    @Autowired
    private EventoRepository eventoRepository;
    @Autowired
    private ConvidadoRepository convidadoRepository;

    @RequestMapping(value="/cadastrarEvento", method = RequestMethod.GET)
    public String form(){
        return "evento/formEvento";
    }

    @RequestMapping(value="/cadastrarEvento", method = RequestMethod.POST)
    public String form(EventoModel evento){
        this.eventoRepository.save(evento);
        return "redirect:/cadastrarEvento";
    }

    @RequestMapping("/eventos")
    public ModelAndView listaEventos() {
        ModelAndView mv = new ModelAndView("index");
        Iterable<EventoModel> eventos = this.eventoRepository.findAll();
        mv.addObject("eventos", eventos);
        return mv;
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ModelAndView detalhesEvento(@PathVariable("id") long id){
        EventoModel evento = this.eventoRepository.findById(id).get();
        ModelAndView mv = new ModelAndView("evento/detalhesEvento");
        Iterable<ConvidadoModel> convidados = this.convidadoRepository.findByEvento(evento);
        mv.addObject("evento", evento);
        mv.addObject("convidados", convidados);
        return mv;
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.POST)
    public String adicionarConvidado(@PathVariable("id") long id, ConvidadoModel convidado){
        EventoModel evento = this.eventoRepository.findById(id).get();
        convidado.setEvento(evento);
        this.convidadoRepository.save(convidado);
        return "redirect:/{id}";
    }
}