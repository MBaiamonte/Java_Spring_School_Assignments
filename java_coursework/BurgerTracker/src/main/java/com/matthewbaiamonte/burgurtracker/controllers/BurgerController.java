package com.matthewbaiamonte.burgurtracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.matthewbaiamonte.burgurtracker.models.Burger;
import com.matthewbaiamonte.burgurtracker.services.BurgerService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/burger")
public class BurgerController {
	@Autowired
	public BurgerService burgerService;
	
//Create Methods
	@GetMapping("/new")
	public String showNewBurgerForm(@ModelAttribute("burger")Burger burger,Model model) {
		model.addAttribute("allBurgers",burgerService.getAll());
		return "BurgersAndForm.jsp";
	}//end get
	
	@PostMapping("/create")
	public String createBurger(@Valid @ModelAttribute("burger")Burger burger, BindingResult result) {
		if (result.hasErrors()) {
			 return "BurgersAndForm.jsp";
		}//end if
		else {
			this.burgerService.createNew(burger);
			System.out.println(burger);
			return "redirect:/burger/new";
		}//end else
	}//end create post
	
//Edit and update methods
	@RequestMapping("/{id}/edit")
	public String showEditBurgerForm(@PathVariable("id")Long id, Model model) {
		model.addAttribute("burger",burgerService.findById(id));
		return "EditBurgerForm.jsp";
	}//end edit get
	
	@PutMapping("/{id}/update")
	public String updateBurger(@Valid @ModelAttribute("burger")Burger burger, BindingResult result,Model model) {
		if (result.hasErrors()) {
			model.addAttribute("burger", burger);
			return "EditBurgerForm.jsp";
		}
		else {
			burgerService.updateBurger(burger);
			return "redirect:/burger/new";
		}//end else
	}//end put mapping
	
//delete Mapping
	@DeleteMapping("/{id}/delete")
	public String deleteBurger(@PathVariable("id")Long id) {
		burgerService.deleteBurger()
		
	}
	
	
	
	
	
	
	
	
}//end class
