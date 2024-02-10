package com.matthewbaiamonte.safetravels.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
/*import org.springframework.web.bind.annotation.DeleteMapping;*/
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.matthewbaiamonte.safetravels.models.Expense;
import com.matthewbaiamonte.safetravels.services.ExpenseService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/expenses")
public class ExpenseController {
	@Autowired
	private ExpenseService expenseService;

//Add new and show all rout
	@GetMapping("")
	public String showNewExpenseForm(@ModelAttribute("expense")Expense expense, Model model) {
		model.addAttribute("allExpenses", expenseService.getAll());
		return "AddNewExpenseForm.jsp";
	}//end get new form
	@PostMapping("/create")
	public String createNewExpanse(@Valid @ModelAttribute("expense")Expense expense,BindingResult result,Model model) {
		if (result.hasErrors()) {
			model.addAttribute("allExpenses",expenseService.getAll());
			return "AddNewExpenseForm.jsp";
		}
		else {
			this.expenseService.createExpense(expense);
			return "redirect:/expenses";
		}
	}//end post create
	
// show one Expense 
	@GetMapping("/show_one/{id}")
	public String showOneExpense(@PathVariable("id")Long id, Model model) {
		model.addAttribute("oneExpense", this.expenseService.getOne(id));
		return "ViewOneExpense.jsp";
	}

//Edit Expense
	@GetMapping("/edit/{id}")
	public String editExpense(@PathVariable("id")Long id, Model model){
		model.addAttribute("expense", this.expenseService.getOne(id));
		return "EditExpenseForm.jsp";
	}
	
	@PutMapping("/update/{id}")//notice @Pathvarible is not specified below, for edits its not required to be specified as long as id is present in the url
	public String updateExpense(@Valid @ModelAttribute("expense")Expense expense, BindingResult result,
			@PathVariable("id")Long id,Model model) {
		if (result.hasErrors()) {
			model.addAttribute("expense", expense);
			return "EditExpenseForm.jsp";
		}
		else {
			this.expenseService.updateExpanse(expense);
			return "redirect:/expenses";
		}
	}
//Delete
	@GetMapping("/delete/{id}")
	public String deleteExpense(@PathVariable("id")Long id) {
		this.expenseService.delete(id);
		return "redirect:/expenses";
	}
	
	
	
	
}//End Controller
