package com.labo.budgets.repositories;

import com.labo.budgets.models.Budget;
import com.labo.budgets.models.BudgetPersonnel;
import com.labo.budgets.models.Utilisateur;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetPersonnelRepo extends JpaRepository<BudgetPersonnel, Long> {
	
	List<BudgetPersonnel> findByBudget(Budget budget);
	
	BudgetPersonnel findByUtilisateurAndBudget(Utilisateur utilisateur, Budget budget);
}
