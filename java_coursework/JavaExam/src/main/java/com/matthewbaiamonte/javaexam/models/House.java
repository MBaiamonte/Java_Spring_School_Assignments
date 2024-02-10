package com.matthewbaiamonte.javaexam.models;


import java.math.BigDecimal;
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
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="houses")
public class House {
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
//Member attributes
	@NotBlank(message="Cannot Be Blank")
	@Size(min=1,max=150,message=("Must Be Between 1 and 150 characters"))
	private String address;
	
	
	@NotNull(message="Cannot Be Blank")
	@DecimalMin(value="0.01",inclusive=true)//validates that the min price can be 1 cent but not less
	@Digits(integer=8,fraction=2,message="Must Be less than 100 million and only have 0-2 decimals")//intergersets amount before decimal, fraction sets max number of decimals 
	private BigDecimal price;
	 
	 //below works as well I just wanted to try it with a decimal 
	/*
	 * @NotNull(message="Cannot Be Empty")
	 * 
	 * @Min(value=1, message="Must Be at Least $1") private Integer price;
	 */
	
//Relationships
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
//Constructor
	public House() {
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

}//end house model
