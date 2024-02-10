package com.matthewbaiamonte.bookstore.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="books")
public class Book {
// next 3 lines generate the Primary key for new objects being added to db
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
// end PK generation bit
//Start member attributes(db columns) setting and validations 
	@NotNull
	@Size(min=5, max=200)
	private String title;
	@NotNull
	@Size(min=5,max=200000)
	private String description;
	@NotBlank
	@Size(min=2,max=20)
	private String language;
	@NotNull
	@Min(100)
	private Integer numOfPages;
//End member attributes(db columns) setting and validations 	
//Start created at + updated at
	@Column(updatable=false) // this line is making it so the created at column in the db can ever be changed once set (set automatically during creation with @PrePersist+@PreUpdate)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
// end created and updated at
//Start constructor (required in domain models)
	public Book() {
	}
	public Book(String constructorTitle,String constructorDescription, String constructorLanguage, int constructorNumOfPages) {
		this.title=constructorTitle;
		this.description=constructorDescription;
		this.language=constructorLanguage;
		this.numOfPages=constructorNumOfPages;
	}
//end Constructor
// Start @PrePersist+@PreUpdate- needed to auto fill in when created or updated. above is just declaring them as field variables for the class
	@PrePersist
	protected void onCreate() {
		this.createdAt=new Date();
	}
	@PreUpdate
	protected void OnUpdate() {
		this.updatedAt=new Date();
	}
//end  @PrePersist+@PreUpdate
//Start getters and setters for each field variable
	public Long getId() {
		return id;
	}
	//dont know if I should have a setter for ID since it should auto set as Primary key when added to the db.
	public void setId(Long id) {
		this.id = id;
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
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Integer getNumOfPages() {
		return numOfPages;
	}
	public void setNumOfPages(Integer numOfPages) {
		this.numOfPages = numOfPages;
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
//end getters and setters for each field variable
}//end class 
