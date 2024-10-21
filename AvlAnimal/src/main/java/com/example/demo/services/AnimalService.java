package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Animal;
import com.example.demo.repositories.AnimalRepository;

@Service
public class AnimalService {

	@Autowired
	private final AnimalRepository animalrepository;
	
	@Autowired
	public AnimalService(AnimalRepository animalrepository) {
		this.animalrepository = animalrepository;
	}
	
	public Animal saveAnimal(Animal animal) {
		return animalrepository.save(animal);
	}

	public Animal getAnimalById(Long id) {
		return animalrepository.findById(id).orElse(null);
	}
	
	public List<Animal> getAllAnimal(){
		return animalrepository.findAll();
	}
	
	public void deleteAnimal(Long id) {
		animalrepository.deleteById(id);
	}
	 
	public Animal updateAnimal(Long id, Animal animalAtualizado) {
	
		Optional<Animal> animalOpcional = animalrepository.findById(id);
		if(animalOpcional.isPresent()) {
			
			Animal animalExistente = animalOpcional.get();
			animalExistente.setNome(animalAtualizado.getNome());
			animalExistente.setRaca(animalAtualizado.getRaca());
			animalExistente.setIdade(animalAtualizado.getIdade());
			animalExistente.setEspecie(animalAtualizado.getEspecie());
			return animalrepository.save(animalExistente);
		} else {
			return null;
		}
	}
	
}
