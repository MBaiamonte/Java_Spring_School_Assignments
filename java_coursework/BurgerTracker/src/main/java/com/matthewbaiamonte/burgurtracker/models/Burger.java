package com.matthewbaiamonte.burgurtracker.models;

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
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="burgers")
public class Burger {
//Start Id auto increment 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
// Start CreatedOn and UpdatedOn
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	@PrePersist
	protected void onCreate() {
		this.createdAt=new Date();
	}
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt=new Date();
	}
// Start field variable declaration 
	@NotBlank(message="Cannot Be Blank")
	@Size(min=5, message="Must Be longer than 5 characters")
	private String burgerName;
	
	@NotBlank (message="Cannot Be Blank")
	@Size(min=5, message="Must Be longer than 5 characters")
	private String restaurantName;
	
	@NotNull(message="Cannot Be Blank")
	@Min(1)
	@Max(5)
	private Integer rating;
	
	@NotBlank
	@Size(min=1)
	private String notes;
//Start Constructors 
	public Burger() {
	}
	public Burger(String burgerName,String restaurantName, Integer rating,String notes) {
		this.burgerName=burgerName;
		this.restaurantName=restaurantName;
		this.rating=rating;
		this.notes=notes;
	}
// Start Getters + Setters
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
	public String getBurgerName() {
		return burgerName;
	}
	public void setBurgerName(String burgerName) {
		this.burgerName = burgerName;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
//end getter and setters
}//End  Model Class
