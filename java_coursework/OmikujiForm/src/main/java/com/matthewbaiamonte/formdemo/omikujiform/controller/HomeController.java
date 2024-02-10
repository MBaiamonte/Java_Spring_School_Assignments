package com.matthewbaiamonte.formdemo.omikujiform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/omikuji")
public class HomeController {
	@RequestMapping()
	public String displayForm() {
		return "OmikujiForm.jsp";
	}
	@PostMapping("/postForm")
	public String processForm(
			@RequestParam(value="number") Integer  number,
			@RequestParam(value="city") String city,
			@RequestParam(value="person") String person,
			@RequestParam(value="hobby") String hobby,
			@RequestParam(value="organisum") String organisum,
			@RequestParam(value="saying") String saying,
			HttpSession session) {
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("hobby", hobby);
		session.setAttribute("organisum", organisum);
		session.setAttribute("saying", saying);
		return "redirect:/omikuji/show";
	}
	@RequestMapping("/show")
	public String showOmikuji(HttpSession session) {
		session.getAttribute("number");
		session.getAttribute("city");
		session.getAttribute("person");
		session.getAttribute("hobby");
		session.getAttribute("organisum");
		session.getAttribute("saying");
		return "ShowOmikuji.jsp";
	}
}
