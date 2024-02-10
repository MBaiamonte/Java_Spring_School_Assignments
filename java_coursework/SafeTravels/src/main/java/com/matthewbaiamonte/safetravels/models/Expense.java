package com.matthewbaiamonte.safetravels.models;

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

@Entity
@Table(name="expenses")
public class Expense {
	
//PK
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
//Update/create
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updateddAt;
	@PrePersist
	protected void onCreate() {
		this.createdAt= new Date();
	}
	@PreUpdate
	protected void onUpdate() {
		this.updateddAt=new Date();
	}
	
//Field Attributes
	@NotBlank(message="Cannot Be Blank")
	private String expenseName;
	@NotBlank(message="Cannot Be Blank")
	private String vendor;
	@NotNull
	@Min(value=0, message="no negitive values")
	private Double amount;
	@NotBlank(message="Cannot Be Blank")
	private String description;
	
// 2 constructors
	public Expense() {
	}
	public Expense(String expenseName,String vendor, Double amount,String description) {
		this.expenseName=expenseName;
		this.vendor=vendor;
		this.amount=amount;
		this.description=description;
	}
// getters and setters
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
	public Date getUpdateddAt() {
		return updateddAt;
	}
	public void setUpdateddAt(Date updateddAt) {
		this.updateddAt = updateddAt;
	}
	public String getExpenseName() {
		return expenseName;
	}
	public void setExpenseName(String expenseName) {
		this.expenseName = expenseName;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}//end expense model
