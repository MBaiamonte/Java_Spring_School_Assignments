package com.matthewbaiamonte.javaexam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matthewbaiamonte.javaexam.models.House;
import com.matthewbaiamonte.javaexam.repositories.HouseRepository;

@Service
public class HouseService {
//Dependency injection
	@Autowired
	private HouseRepository houseRepository;
	
//Create New 
	public House createHouse(House newHouse) {
		return this.houseRepository.save(newHouse);
	}
//Update 
	public House updateHose(House updatedHouse) {
		return this.houseRepository.save(updatedHouse);
	}
//Get All Houses
	public List<House> getAllHouses(){
		return houseRepository.findAll();
	}
//Get One 
	public House getOneHouse(Long id) {
		return houseRepository.findById(id).orElse(null);
	}
//Delete
	public void deleteHouse(Long id) {
		this.houseRepository.deleteById(id);
	}
	
	
	
	
	
	
	
	
}//End house service
