package com.labo.budgets.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labo.budgets.models.Budget;
import com.labo.budgets.repositories.BudgetRepo;
import com.labo.budgets.repositories.LaboratoireRepo;

@Service
public class BudgetService {
	
	 private BudgetRepo budgetRepo;
	 private LaboratoireRepo laboratoireRepo;
	 
	 @Autowired
	 public BudgetService(BudgetRepo budgetRepo, LaboratoireRepo laboratoireRepo) {
		 this.budgetRepo = budgetRepo;
		 this.laboratoireRepo = laboratoireRepo;
	 }
	 
	 public Budget newBudget(String nom, Budget budget) {
		 budget.setLabo(this.laboratoireRepo.findByNom(nom));
		 if(this.budgetRepo.findByLaboAndAnnee(budget.getLabo(), budget.getAnnee()) == null)
		 return this.budgetRepo.save(budget);
		 return null;
	 }
	 
	 public List<Budget> laboBudget(String labo){
		 return this.laboratoireRepo.findBudgetsByLabo(labo);
	 }

}
