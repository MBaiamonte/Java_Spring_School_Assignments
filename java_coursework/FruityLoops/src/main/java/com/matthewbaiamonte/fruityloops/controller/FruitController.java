package com.matthewbaiamonte.fruityloops.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.matthewbaiamonte.model.Item;

@Controller
public class FruitController {
	@RequestMapping("/")
	public String fruitStorePage(Model model) {
		ArrayList<Item>fruitStore=new ArrayList<Item>();
		fruitStore.add(new Item("Kiwi", 1.50));
		fruitStore.add(new Item("Mango", 2.00));
		fruitStore.add(new Item("Goji Berrys", 4.00));
		fruitStore.add(new Item("Guava", .075));
		model.addAttribute("fruitStoreInvintory",fruitStore);
		return "FruityLoops.jsp";
	}

}
