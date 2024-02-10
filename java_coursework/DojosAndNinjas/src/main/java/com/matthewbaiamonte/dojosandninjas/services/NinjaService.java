package com.matthewbaiamonte.dojosandninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matthewbaiamonte.dojosandninjas.models.Ninja;
import com.matthewbaiamonte.dojosandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	@Autowired
	private NinjaRepository ninjaRepository;
	
//Create
	public Ninja createNewNinja(Ninja newNinja) {
		return ninjaRepository.save(newNinja);
	}
//Update
	public Ninja updateNinja(Ninja updatedNinja) {
		return ninjaRepository.save(updatedNinja);
	}
//get one
	public Ninja getOneNinja(Long id) {
		return ninjaRepository.findById(id).orElse(null);
	}
//Get All
	public List<Ninja> getAllNinjas(){
		return ninjaRepository.findAll();
	}
//Delete 
	public void DeleteNinja(Long id) {
		ninjaRepository.deleteById(id);
	}
	
	
	
	
	
}//End service
