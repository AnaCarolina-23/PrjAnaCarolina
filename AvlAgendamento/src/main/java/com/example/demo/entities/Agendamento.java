package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class Agendamento {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String data;
	private String duracao;
	private double preco;
	
	
	//metodos de acesso
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	//
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	//
	public String getDuracao() {
		return duracao;
	}
	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}
	//
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	//
}
