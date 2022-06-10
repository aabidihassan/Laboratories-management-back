package com.labo.budgets.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.labo.budgets.models.Budget;
import com.labo.budgets.models.Utilisateur;
import com.labo.budgets.services.BudgetService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/budgets")
public class BudgetController {
	
	private BudgetService budgetService;
	
	@Autowired
	public BudgetController(BudgetService budgetService) {
		this.budgetService = budgetService;
	}
	
	@PostMapping("/{labo}")
    @PreAuthorize("hasAuthority('RESPO')")
    public Budget newBudget(@PathVariable(name="labo") String labo,@RequestBody Budget budget) {
    	return this.budgetService.newBudget(labo, budget);
    }
	
	@GetMapping("/{labo}")
    @PreAuthorize("hasAuthority('RESPO')")
    public List<Budget> budgets(@PathVariable(name="labo") String labo) {
    	return this.budgetService.laboBudget(labo);
    }

}
