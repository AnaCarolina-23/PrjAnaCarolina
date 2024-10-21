package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Cliente;
import com.example.demo.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private final ClienteRepository clienterepository;
	
	@Autowired
	public ClienteService(ClienteRepository clienterepository) {
		this.clienterepository = clienterepository;
	}
	
	public Cliente saveCliente(Cliente cliente) {
		return clienterepository.save(cliente);
	}

	public Cliente getClienteById(Long id) {
		return clienterepository.findById(id).orElse(null);
	}
	
	public List<Cliente> getAllCliente(){
		return clienterepository.findAll();
	}
	
	public void deleteCliente(Long id) {
		clienterepository.deleteById(id);
	}
	
	public Cliente updateCliente(Long id, Cliente clienteAtualizado) {
	
		Optional<Cliente> clienteOpcional = clienterepository.findById(id);
		if(clienteOpcional.isPresent()) {
			
			Cliente clienteExistente = clienteOpcional.get();
			clienteExistente.setNome(clienteAtualizado.getNome());
			clienteExistente.setCpf(clienteAtualizado.getCpf());
			clienteExistente.setIdade(clienteAtualizado.getIdade());
			clienteExistente.setContato(clienteAtualizado.getContato());
			return clienterepository.save(clienteExistente);
		} else {
			return null;
		}
	}
	
}
