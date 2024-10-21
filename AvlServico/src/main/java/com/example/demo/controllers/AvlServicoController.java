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

import com.example.demo.entities.Servico;
import com.example.demo.services.ServicoService;

@RestController
@RequestMapping("/servicos")
public class AvlServicoController {

	private final ServicoService servicoservice;
	
	@Autowired
	public AvlServicoController(ServicoService servicoservice) {
		this.servicoservice = servicoservice;
	}
	
	@PostMapping
	public Servico createServico(@RequestBody Servico servico) {
		return servicoservice.saveServico(servico);
	}
	
	@GetMapping
	public List<Servico> getAllServico(){
		return servicoservice.getAllServico();
	}
	
	@GetMapping("/{id}")
	public Servico getServico(@PathVariable Long id) {
		return servicoservice.getServicoById(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteServico(@PathVariable Long id) {
		servicoservice.deleteServico(id);
	}

	@PutMapping("/{id}")
	public Servico updateServico(@PathVariable Long id, @RequestBody Servico servico) {
		return servicoservice.updateServico(id, servico);
	}
}