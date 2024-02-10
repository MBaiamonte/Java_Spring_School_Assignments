package com.matthewbaiamonte.safetravels.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matthewbaiamonte.safetravels.models.Expense;
import com.matthewbaiamonte.safetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	@Autowired
	private ExpenseRepository expenseRepository;
//Get All
	public List<Expense> getAll(){
		return expenseRepository.findAll();
	}
//Get One
	public Expense getOne(Long id) {
		return expenseRepository.findById(id).orElse(null);
	}
//Create
	public Expense createExpense(Expense newExpense) {
		return expenseRepository.save(newExpense);
	}
//Update
	public Expense updateExpanse(Expense updatedExpense) {
		return expenseRepository.save(updatedExpense);
	}
//Delete
	public void delete(Long id) {
		this.expenseRepository.deleteById(id);
	}
	
	
}//end service class
