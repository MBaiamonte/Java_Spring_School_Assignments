package com.matthewbaiamonte.dojosandninjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.matthewbaiamonte.dojosandninjas.models.Dojo;
import com.matthewbaiamonte.dojosandninjas.models.Ninja;
import com.matthewbaiamonte.dojosandninjas.services.DojoService;
import com.matthewbaiamonte.dojosandninjas.services.NinjaService;

import jakarta.validation.Valid;

@Controller
public class MainController {
//Dependency injection for services
	@Autowired
	private DojoService dojoService;
	
	@Autowired 
	private NinjaService ninjaService;

//Create new dojo + HomePage
	@GetMapping("/")
	public String homepage(@ModelAttribute("dojo")Dojo newDojo) {
		return "NewDojoForm.jsp";
	}
	@PostMapping("dojo/create/new/")
	public String createDojo(@Valid @ModelAttribute("dojo")Dojo newDojo,BindingResult result) {
		if (result.hasErrors()) {
			return "NewDojoForm.jsp";
		}
		else {
			this.dojoService.createNewDojo(newDojo);
			System.out.println(newDojo);
			return "redirect:/";
		}
	}
	
//Create new ninja
	@GetMapping("/ninja/new/show_form")
	public String showNewNinjaForm(@ModelAttribute("ninja")Ninja newNinja, Model model) {
		model.addAttribute("dojos", dojoService.getAllDojos());
		return "NewNinjaForm.jsp";
	}
	@PostMapping("/ninja/new/create")
	public String createNinja(@Valid @ModelAttribute("ninja")Ninja newNinja,BindingResult result,Model model) {
		if(result.hasErrors()) {
			model.addAttribute("dojos", dojoService.getAllDojos());
			return "NewNinjaForm.jsp";
		}
		else {
			this.ninjaService.createNewNinja(newNinja);
			return "redirect:/ninja/new/show_form";
		}
	}
//Display dojo with ninjas
	@GetMapping("/dojos/{dojo_id}")
	public String showDojoWithNinjas(@PathVariable("dojo_id")Long id,Model model) {
		model.addAttribute("dojo", dojoService.getOneDojo(id));
		return "DisplayDojoWithNinjas.jsp";
	}
	
	
	
	
	
	
	
	
}//End Controller
