package com.matthewbaiamonte.projectmanager.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="projects")
public class Project {
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
//Member Attributes
	@NotBlank(message="Cannot Be Blank")
	@Size(min=2, max=100,message="Must Be Between 2 and 100 Characters")
	private String title;
	
	@NotBlank(message="Cannot Be Blank")
	@Size(min=2, max=6000,message="Must Be Between 2 and 6,000 Characters")
	private String description;
	
	@FutureOrPresent(message="Must Be Current Or Future Date, Not Past Date")
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dueDate;
	
//Relationships
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="creator_id")//same as user_id, this is just what were namming it
	private User creator;
	
	
	
	/*
	 * @ManyToMany(fetch=FetchType.LAZY)
	 * 
	 * @JoinTable( name="users_projects", joinColumns
	 * =@JoinColumn(name="project_id"),
	 * inverseJoinColumns=@JoinColumn(name="user_id") ) private List<User> users;
	 * 
	 * @OneToOne(mappedBy="project", cascade=CascadeType.ALL,fetch= FetchType.LAZY)
	 * private Team team;
	 */
	  
//Constructors
	  public Project() {
	  }
//Getters and Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public User getCreator() {
		return creator;
	}
	public void setCreator(User creator) {
		this.creator = creator;
	}
	 
	

}//end project class
