package com.labo.budgets.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labo.budgets.models.Budget;
import com.labo.budgets.models.BudgetPersonnel;
import com.labo.budgets.models.Utilisateur;
import com.labo.budgets.repositories.BudgetPersonnelRepo;
import com.labo.budgets.repositories.UtilisateurRepo;

@Service
public class BudgetPersonnelService {
	
	private BudgetPersonnelRepo budgetPersonnelRepo;
	private AccountServiceImpl accountService;
	
	@Autowired
	public BudgetPersonnelService(BudgetPersonnelRepo budgetPersonnelRepo, AccountServiceImpl accountService) {
		this.budgetPersonnelRepo = budgetPersonnelRepo;
		this.accountService = accountService;
	}
	
	public List<BudgetPersonnel> getBudgetsPersonnelByLabo(int id){
		return this.budgetPersonnelRepo.findByBudget(new Budget(id, 0, 0, null, null, null));
	}
	
	public List<Utilisateur> bpWithUsersByBudget(int id, String username){
		System.out.println("hiiiiiiiiiiiiiiiiiiiiiiii hola");
		List<Utilisateur> users = this.accountService.getLaboUsers(username);
		users.forEach(u->{
			u.getBudgetPersonnels().clear();
			u.getBudgetPersonnels().add(this.budgetPersonnelRepo.findByUtilisateurAndBudget(u,new Budget(id, 0, 0, null, null, null)));
		});
		return users;
	}

}
