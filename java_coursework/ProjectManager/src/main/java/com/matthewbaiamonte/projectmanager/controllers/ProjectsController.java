package com.matthewbaiamonte.projectmanager.controllers;

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

import com.matthewbaiamonte.projectmanager.models.Project;
import com.matthewbaiamonte.projectmanager.services.ProjectService;
import com.matthewbaiamonte.projectmanager.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/project")
public class ProjectsController {
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private UserService userService;
	
//Create New Project 
	@GetMapping("/add/new")
	public String ShowNewProjectForm(@ModelAttribute("newProject")Project newProject,
			HttpSession session,
			Model model) {
		model.addAttribute("userId", session.getAttribute("userId"));
		return "NewProjectForm.jsp";
	}
	@PostMapping("/save/new")
	public String SaveProject(@Valid @ModelAttribute("newProject")Project newProject,
			BindingResult result,
			Model model,
			HttpSession session) {
		if(result.hasErrors()) {
			model.addAttribute("userId", session.getAttribute("userId"));
			System.out.println(session.getAttribute("userId"));
			return "NewProjectForm.jsp";
		} else {
			this.projectService.createNewProject(newProject);
			return "redirect:/user/dashboard";
		}
	}
//update project 
	@GetMapping("/show/edit/{projectId}")
	public String ShowEditForm(@PathVariable("projectId")Long id,
			HttpSession session, Model model) {
		model.addAttribute("project", this.projectService.getOneProject(id));
		System.out.println(this.projectService.getOneProject(id));
		return "EditProjectForm.jsp";
	}
	 @PutMapping("/save/edit/{id}")
	 public String saveUpdateProject(@Valid @ModelAttribute("updatedProject")Project updatedProject,
			 BindingResult result,
			 HttpSession session,
			 Model model) {
		 if(result.hasErrors()) {
			 model.addAttribute("userId", session.getAttribute("userId"));
				/* model.addAttribute("project", projectService.getOneProject(id)) ; */
			 return "EditProjectForm.jsp";
		 }else {
			 this.projectService.updateProject(updatedProject);
			 return "redirect:/user/dashboard";
		 }
	 }
	
	
	
	
	
	
	
	
	
	
	
}//End controller
