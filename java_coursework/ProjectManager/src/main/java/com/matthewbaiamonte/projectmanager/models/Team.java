package com.matthewbaiamonte.projectmanager.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="teams")
public class Team {
//PK
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
		
//Update/create
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	@PrePersist
	protected void onCreate() {
		this.createdAt= new Date();
	}
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt=new Date();
	}
//Field attributes
	@NotBlank
	@Size(min=1,max=50)
	private String teamLead;
	
//Relationships
	@OneToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="project_id")
	private Project project;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="teams_users",
			joinColumns = @JoinColumn(name="team_id"),
			inverseJoinColumns =@JoinColumn(name="user_id")
			)
	private List<User> teamMembers;
	
/*	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private List<User> teamMembers;*/
//Constructors
	public Team() {
	}
//Getters and Setters
	


}//end model
