package com.matthewbaiamonte.dojosandninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matthewbaiamonte.dojosandninjas.models.Dojo;
import com.matthewbaiamonte.dojosandninjas.repositories.DojoRepository;

@Service
public class DojoService {
	@Autowired
	private DojoRepository dojoRepository;
	
//get one
	public Dojo getOneDojo(Long id) {
		return dojoRepository.findById(id).orElse(null);
	}
//Create
	public Dojo createNewDojo(Dojo newDojo) {
		return dojoRepository.save(newDojo);
	}
	
	
//not needed but i'm going to include
//Update
	public Dojo updateDojo(Dojo updatedDojo) {
		return dojoRepository.save(updatedDojo);
	}
//Delete
	public void deleteDojo(Long id) {
		dojoRepository.deleteById(id);
	}
//GetAll
	public List<Dojo> getAllDojos(){
		return dojoRepository.findAll();
	}
	
	
	
	
	
	
	
}//End Dojo Service
