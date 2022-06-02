package com.codingdojo.savetravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.savetravels.models.Expense;
import com.codingdojo.savetravels.services.ExpenseService;

@Controller
public class HomeController {
	
	@Autowired
	ExpenseService expenseService;
	
	@RequestMapping("/expense")
	public String index(Model model) {
		List<Expense> expenses = expenseService.allExpenses();
		model.addAttribute("allExpenses", expenses);
		return "index.jsp";
	}
	@GetMapping("/expense/new")
	public String newExpense(@ModelAttribute("expense") Expense expense) {
		return "new.jsp";
	}
	@GetMapping("/expense/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Expense expense = expenseService.findExpense(id);
		model.addAttribute("expense", expense);
		return "edit.jsp";
		
	}
	@RequestMapping("/expense/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Expense expense = expenseService.findExpense(id);
		model.addAttribute("expense", expense);
		return "show.jsp";
	}
	
	@PutMapping("/expense/{id}")
	public String update(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}
		else {
			expenseService.createExpense(expense);
			return "redirect:/expense";
		}
	}
	
	@DeleteMapping("/expense/{id}/destroy")
	public String destroy(@PathVariable Long id) {
		expenseService.deleteById(id);
		return "redirect:/expense";
	}
	
    @PostMapping("/expense")
    public String create(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
        if (result.hasErrors()) {
            return "new.jsp";
        } else {
            expenseService.createExpense(expense);
            return "redirect:/expense";
        }
    }
	
}
