package com.matthewbaiamonte.javaexam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.matthewbaiamonte.javaexam.models.LoginUser;
import com.matthewbaiamonte.javaexam.models.User;
import com.matthewbaiamonte.javaexam.services.HouseService;
import com.matthewbaiamonte.javaexam.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired HouseService houseService;
	
	
	@GetMapping("")
	public String ShowRegisterAndLoginForm(@ModelAttribute("newUser") User newUser,
			@ModelAttribute("loginUser")LoginUser loginUser,
			Model model,HttpSession session) {
		session.invalidate();
		return "LoginPage.jsp";
	}
	
	@PostMapping("/register")
	public String registerNewUser(@Valid @ModelAttribute("newUser")User newUser,
			BindingResult result,Model model, HttpSession session) {
		User theNewUser =this.userService.register(newUser, result);
		if(result.hasErrors()) {
			model.addAttribute("loginUser", new LoginUser());//reloads a new empty LoginUser bean when there's errors on the register form
			return "LoginPage.jsp";
		}
		else {
			session.setAttribute("userId", theNewUser.getId());
			return "redirect:/user/dashboard";
		}
	}//registration post end
	
	@GetMapping("/dashboard")
	public String dashboard(Model model, HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/user";
		}else {
			Long userId = (long) session.getAttribute("userId");
			model.addAttribute("allHouses", houseService.getAllHouses()); 
			model.addAttribute("loggedinUser", this.userService.findById(userId));
			return "Dashboard.jsp";
		}
	}
	
	@GetMapping("/logout")
	public String logoutUser(HttpSession session) {
		session.invalidate();
		return "redirect:/user";
	}
	
	@PostMapping("/login")
	public String LoginAUser(@Valid @ModelAttribute("loginUser")LoginUser loginUser,
			BindingResult result,
			HttpSession session,
			Model model) {
		User user = userService.login(loginUser, result);
		if(result.hasErrors()) {
			model.addAttribute("newUser",new User());//reloads a new empty User bean when there's errors on the login form
			return "LoginPage.jsp";
		}
		else {
			session.setAttribute("userId", user.getId());
			return "redirect:/user/dashboard";
		}
	}
}//end controller

