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
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
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
//Relationships
	/*
	 * @ManyToMany(fetch=FetchType.LAZY)
	 * 
	 * @JoinTable( name="users_projects", joinColumns=@JoinColumn(name="user_id"),
	 * inverseJoinColumns = @JoinColumn(name="project_id") ) private List<Project>
	 * project;
	 * 
	 * @ManyToMany(fetch=FetchType.LAZY)
	 * 
	 * @JoinTable( name="teams_users", joinColumns = @JoinColumn(name="user_id"),
	 * inverseJoinColumns =@JoinColumn(name="team_id") ) private List<Team>
	 * usersTeams;
	 */

//Member attributes
    @NotBlank(message="First Name is required!")
    @Size(min=3, max=30, message="First Name must be between 3 and 30 characters")
    private String firstName;
    
    @NotBlank(message="Last Name is required!")
    @Size(min=3, max=30, message="Last Name must be between 3 and 30 characters")
    private String lastName;
    
    @NotBlank(message="Email is required!")
    @Email(message="Please enter a valid email!")//@Email validates the email entered is valid/correct format
    private String email;
    
    @NotEmpty(message="Password is required!")
    @Size(min=8, max=128, message="Password must be between 8 and 128 characters")
    private String password;
    
    @Transient //@Transient wont save to db when object is sent over to be saved
    @NotEmpty(message="Confirm Password is required!")
    @Size(min=8, max=128, message="Confirm Password must be between 8 and 128 characters")
    private String confirm;
 
//Relationships
    @OneToMany(mappedBy="creator",fetch= FetchType.LAZY) //creator is same as user but this is wat its named in project model
    private List<Project> myProjects;
    
    
	/*
	 * @ManyToMany(fetch=FetchType.LAZY)
	 * 
	 * @JoinTable( name="users_projects", joinColumns =@JoinColumn(name="user_id"),
	 * inverseJoinColumns=@JoinColumn(name="project_id") ) private List<Project>
	 * projects;
	 */
//Constructors
    public User() {
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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirm() {
		return confirm;
	}
	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
	public List<Project> getMyProjects() {
		return myProjects;
	}
	public void setMyProjects(List<Project> myProjects) {
		this.myProjects = myProjects;
	}

	
}//end user class
