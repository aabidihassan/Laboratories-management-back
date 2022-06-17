package com.labo.budgets.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.labo.budgets.models.BudgetPersonnel;
import com.labo.budgets.models.Utilisateur;
import com.labo.budgets.services.BudgetPersonnelService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/bp")
public class BudgetPersonnelController {
	
	private BudgetPersonnelService budgetPersonnelService;
	
	@Autowired
	public BudgetPersonnelController(BudgetPersonnelService budgetPersonnelService) {
		this.budgetPersonnelService = budgetPersonnelService;
	}
	
	@GetMapping(path = "/byidbudget/{id}")
    @PreAuthorize("hasAuthority('RESPO')")
	public List<BudgetPersonnel> bpByIdBudget(@PathVariable(name="id")int id) {
		return this.budgetPersonnelService.getBudgetsPersonnelByLabo(id);
	}
	
	@GetMapping(path = "/withusers/{user}")
    @PreAuthorize("hasAuthority('RESPO')")
	public List<Utilisateur> bpWithUsers(@PathVariable(name="user") String user, @Param("id") int id) {
		return this.budgetPersonnelService.bpWithUsersByBudget(id, user);
	}
	
	@PostMapping(path = "/")
    @PreAuthorize("hasAuthority('RESPO')")
	public BudgetPersonnel create(@RequestBody BudgetPersonnel bp) {
		return this.budgetPersonnelService.save(bp);
	}
	
	@GetMapping(path = "/byuser/{username}")
    @PreAuthorize("hasAuthority('RESPO') or hasAuthority('USER')")
	public List<Object[]> bpByUser(@PathVariable(name="username") String username) {
		Utilisateur user = new Utilisateur();
		user.setUsername(username);
		return this.budgetPersonnelService.getUserBp(user);
	}

}
