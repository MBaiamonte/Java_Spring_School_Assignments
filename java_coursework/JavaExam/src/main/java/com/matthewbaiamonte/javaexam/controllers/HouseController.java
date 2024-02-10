package com.matthewbaiamonte.javaexam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.matthewbaiamonte.javaexam.models.House;
import com.matthewbaiamonte.javaexam.services.HouseService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/house")
public class HouseController {
	@Autowired
	private HouseService houseService;
	
//create new routes----------------------------------------------------------------------------------------
	@GetMapping("/add/new")
	public String ShowNewHouseForm(@ModelAttribute("newHouse")House newHouse,Model model,HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/user";
		}else {

		model.addAttribute("userId", session.getAttribute("userId"));
		System.out.println(session.getAttribute("userId"));
		return "NewHouseForm.jsp";}
	}
	@PostMapping("/save/new")
	public String saveNewHouse(@Valid @ModelAttribute("newHouse")House newHouse,
			BindingResult result,
			Model model, 
			HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/user";
		}else {
		if(result.hasErrors()) {
			model.addAttribute("userId", session.getAttribute("userId"));
			System.out.println(session.getAttribute("userId"));
			return "NewHouseForm.jsp";
		}else {
			this.houseService.createHouse(newHouse);
			return "redirect:/user/dashboard";
		}
		}
	}

//Show one Routes----------------------------------------------------------------------------------------------------
	@GetMapping("/show/{houseId}")
	public String showOneHouse(@PathVariable("houseId")Long houseId, Model model,HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/user";}
		else {
		model.addAttribute("house", this.houseService.getOneHouse(houseId));
		model.addAttribute("userId", session.getAttribute("userId"));
		return "ShowOneHousePage.jsp";
		}
	}
//Delete---------------------------------------------------------------------------------------------------------------
	@GetMapping("/delete/{house_id}")
	public String deleteOneHouse(@PathVariable("house_id")Long id,HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/user";}
		else {
			this.houseService.deleteHouse(id);
			return "redirect:/user/dashboard";
		}
	}
	
//update routes-------------------------------------------------------------------------------------------------------
	@GetMapping("/show/update/{houseId}")
	public String showUpdateForm(@PathVariable("houseId")long id,
			Model model,
			HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/user";}
		else {
			model.addAttribute("house", this.houseService.getOneHouse(id));
			/* model.addAttribute("userId", session.getAttribute("userId")); */
			return "HouseUpdatedForm.jsp";
		}
	}
	@PutMapping("/update/{id}")
	public String saveUpdatedHouse(@Valid @ModelAttribute("house")House updatedHouse,
			BindingResult result,
			Model model,
			HttpSession session,@PathVariable("id")Long id ) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/user";}
		else {
			if (result.hasErrors()) {
				model.addAttribute("userId", session.getAttribute("userId"));
				return "HouseUpdatedForm.jsp";
			}
			else {
				this.houseService.updateHose(updatedHouse);
				return "redirect:/user/dashboard";
			}
		}
	}


}//end controller
