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

import com.example.demo.entities.Animal;
import com.example.demo.services.AnimalService;

@RestController
@RequestMapping("/animais")
public class AvlAnimalController {

	private final AnimalService animalservice;
	
	@Autowired
	public AvlAnimalController(AnimalService animalservice) {
		this.animalservice = animalservice;
	}
	
	@PostMapping
	public Animal createAnimal(@RequestBody Animal animal) {
		return animalservice.saveAnimal(animal);
	}
	
	@GetMapping
	public List<Animal> getAllAnimal(){
		return animalservice.getAllAnimal();
	}
	
	@GetMapping("/{id}")
	public Animal getAnimal(@PathVariable Long id) {
		return animalservice.getAnimalById(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteAnimal(@PathVariable Long id) {
		animalservice.deleteAnimal(id);
	}

	@PutMapping("/{id}")
	public Animal updateAnimal(@PathVariable Long id, @RequestBody Animal animal) {
		return animalservice.updateAnimal(id, animal);
	}
}