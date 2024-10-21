package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Agendamento;
import com.example.demo.repositories.AgendamentoRepository;

@Service
public class AgendamentoService {

	@Autowired
	private final AgendamentoRepository agendamentorepository;
	
	@Autowired
	public AgendamentoService(AgendamentoRepository agendamentorepository) {
		this.agendamentorepository = agendamentorepository;
	}
	
	public Agendamento saveAgendamento(Agendamento agendamento) {
		return agendamentorepository.save(agendamento);
	}

	public Agendamento getAgendamentoById(Long id) {
		return agendamentorepository.findById(id).orElse(null);
	}
	
	public List<Agendamento> getAllAgendamento(){
		return agendamentorepository.findAll();
	}
	
	public void deleteAgendamento(Long id) {
		agendamentorepository.deleteById(id);
	}
	
	public Agendamento updateAgendamento(Long id, Agendamento agendamentoAtualizado) {
	
		Optional<Agendamento> agendamentoOpcional = agendamentorepository.findById(id);
		if(agendamentoOpcional.isPresent()) {
			
			Agendamento agendamentoExistente = agendamentoOpcional.get();
			agendamentoExistente.setData(agendamentoAtualizado.getData());
			agendamentoExistente.setDuracao(agendamentoAtualizado.getDuracao());
			agendamentoExistente.setPreco(agendamentoAtualizado.getPreco());
			return agendamentorepository.save(agendamentoExistente);
		} else {
			return null;
		}
	}
	
}
