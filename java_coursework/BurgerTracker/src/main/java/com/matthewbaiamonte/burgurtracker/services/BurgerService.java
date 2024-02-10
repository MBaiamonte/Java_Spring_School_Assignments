package com.matthewbaiamonte.burgurtracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matthewbaiamonte.burgurtracker.models.Burger;
import com.matthewbaiamonte.burgurtracker.repositories.BurgerRepository;
@Service
public class BurgerService {
//Created link for dependency injection for repository access 
	@Autowired
	private BurgerRepository burgerRepository;
//Created constructor of dependency from above might be handeld by @autowired
// Create Crud routes for create,update,findAll,findById, Delete 
	public List<Burger> getAll(){
		return burgerRepository.findAll();
	}
//Get one
	public Burger findById(Long id) {
		return burgerRepository.findById(id).orElse(null);
	}
//Create
	public Burger createNew(Burger burger) {
		return burgerRepository.save(burger);
	}
//Update
	public Burger updateBurger(Burger burger) {
		return burgerRepository.save(burger);
	}
//Delete

	
	
	
	
	
	
}//end service class
