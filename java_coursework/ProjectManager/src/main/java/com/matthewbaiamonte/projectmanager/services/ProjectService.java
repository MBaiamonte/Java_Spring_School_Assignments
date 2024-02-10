package com.matthewbaiamonte.projectmanager.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matthewbaiamonte.projectmanager.models.Project;
import com.matthewbaiamonte.projectmanager.repositories.ProjectRepository;

@Service
public class ProjectService {
	@Autowired
	private ProjectRepository projectRepositoy;
	
//get one
	public Project getOneProject(Long id) {
		return projectRepositoy.findById(id).orElse(null);
	}
//Get All
	public List<Project> getAllProjects(){
		return projectRepositoy.findAll();
	}
//Create
	public Project createNewProject(Project newProject) {
		return this.projectRepositoy.save(newProject);
	}
//Update
	public Project updateProject(Project updatedProject) {
		return this.projectRepositoy.save(updatedProject);
	}
//Delete
	public void deleteProject(Long id) {
		this.projectRepositoy.deleteById(id);
	}
	
	
	
	
}
