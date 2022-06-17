package com.labo.budgets.repositories;

import com.labo.budgets.models.Besoin;
import com.labo.budgets.models.BudgetPersonnel;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource
public interface BesoinRepo extends JpaRepository<Besoin, Long> {
	
	List<Besoin> findByPudgetPersonnel(BudgetPersonnel budgetPersonnel);
	
}
