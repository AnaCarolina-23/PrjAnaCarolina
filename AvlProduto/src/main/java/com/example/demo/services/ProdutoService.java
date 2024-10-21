package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Produto;
import com.example.demo.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private final ProdutoRepository produtorepository;
	
	@Autowired
	public ProdutoService(ProdutoRepository produtorepository) {
		this.produtorepository = produtorepository;
	}
	
	public Produto saveProduto(Produto produto) {
		return produtorepository.save(produto);
	}

	public Produto getProdutoById(Long id) {
		return produtorepository.findById(id).orElse(null);
	}
	
	public List<Produto> getAllProduto(){
		return produtorepository.findAll();
	}
	
	public void deleteProduto(Long id) {
		produtorepository.deleteById(id);
	}
	
	public Produto updateProduto(Long id, Produto produtoAtualizado) {
	
		Optional<Produto> produtoOpcional = produtorepository.findById(id);
		if(produtoOpcional.isPresent()) {
			
			Produto produtoExistente = produtoOpcional.get();
			produtoExistente.setNome(produtoAtualizado.getNome());
			produtoExistente.setEstoque(produtoAtualizado.getEstoque());
			produtoExistente.setPreco(produtoAtualizado.getPreco());
			return produtorepository.save(produtoExistente);
		} else {
			return null;
		}
	}
	
}
