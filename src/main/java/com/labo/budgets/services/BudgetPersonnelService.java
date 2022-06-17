package com.labo.budgets.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labo.budgets.models.Budget;
import com.labo.budgets.models.BudgetPersonnel;
import com.labo.budgets.models.Utilisateur;
import com.labo.budgets.repositories.BudgetPersonnelRepo;
import com.labo.budgets.repositories.BudgetRepo;
import com.labo.budgets.repositories.UtilisateurRepo;

@Service
public class BudgetPersonnelService {
	
	private BudgetPersonnelRepo budgetPersonnelRepo;
	private AccountServiceImpl accountService;
	private BudgetRepo budgetRepo;
	
	@Autowired
	public BudgetPersonnelService(BudgetRepo budgetRepo, BudgetPersonnelRepo budgetPersonnelRepo, AccountServiceImpl accountService) {
		this.budgetPersonnelRepo = budgetPersonnelRepo;
		this.accountService = accountService;
		this.budgetRepo = budgetRepo;
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
	
	public BudgetPersonnel save(BudgetPersonnel bp) {
		return this.budgetPersonnelRepo.save(bp);
	}
	
	public List<Object[]> getUserBp(Utilisateur user){
		List<Object[]> obj = new ArrayList<Object[]>();
		List<BudgetPersonnel> bp = this.budgetPersonnelRepo.findByUtilisateur(user);
		bp.forEach(b->{
			Object[] ob = new Object[2]; ob[0] = b; ob[1] = b.getBudget();
			obj.add(ob);
		});
		return obj;
	}

}
