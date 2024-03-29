package com.matthewbaiamonte.projectmanager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.matthewbaiamonte.projectmanager.models.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project,Long> {
	List<Project> findAll();
}
