package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Agendamento;
import com.example.demo.services.AgendamentoService;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

	private final AgendamentoService agendamentoservice;
	
	@Autowired
	public AgendamentoController(AgendamentoService agendamentoservice) {
		this.agendamentoservice = agendamentoservice;
	}
	
	@PostMapping
	public Agendamento createAgendamento(@RequestBody Agendamento agendamento) {
		return agendamentoservice.saveAgendamento(agendamento);
	}
	
	@GetMapping
	public List<Agendamento> getAllAgendamento(){
		return agendamentoservice.getAllAgendamento();
	}
	
	@GetMapping("/{id}")
	public Agendamento getAgendamento(@PathVariable Long id) {
		return agendamentoservice.getAgendamentoById(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteAgendamento(@PathVariable Long id) {
		agendamentoservice.deleteAgendamento(id);
	}

	@PutMapping("/{id}")
	public Agendamento updateAgendamento(@PathVariable Long id, @RequestBody Agendamento agendamento) {
		return agendamentoservice.updateAgendamento(id, agendamento);
	}
}