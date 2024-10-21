package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Servico;
import com.example.demo.repositories.ServicoRepository;

@Service
public class ServicoService {

	@Autowired
	private final ServicoRepository servicorepository;
	
	@Autowired
	public ServicoService(ServicoRepository servicorepository) {
		this.servicorepository = servicorepository;
	}
	
	public Servico saveServico(Servico servico) {
		return servicorepository.save(servico);
	}

	public Servico getServicoById(Long id) {
		return servicorepository.findById(id).orElse(null);
	}
	
	public List<Servico> getAllServico(){
		return servicorepository.findAll();
	}
	
	public void deleteServico(Long id) {
		servicorepository.deleteById(id);
	}
	
	public Servico updateServico(Long id, Servico servicoAtualizado) {
	
		Optional<Servico> servicoOpcional = servicorepository.findById(id);
		if(servicoOpcional.isPresent()) {
			
			Servico servicoExistente = servicoOpcional.get();
			servicoExistente.setNome(servicoAtualizado.getNome());
			servicoExistente.setTempo(servicoAtualizado.getTempo());
			servicoExistente.setPreco(servicoAtualizado.getPreco());
			return servicorepository.save(servicoExistente);
		} else {
			return null;
		}
	}
	
}
