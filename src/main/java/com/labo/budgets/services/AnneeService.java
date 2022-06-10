package com.labo.budgets.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labo.budgets.models.Annee;
import com.labo.budgets.models.Laboratoire;
import com.labo.budgets.repositories.AnneeRepo;
import com.labo.budgets.repositories.BudgetRepo;
import com.labo.budgets.repositories.LaboratoireRepo;

@Service
public class AnneeService {
	
	private AnneeRepo anneeRepo;
	
	@Autowired
	public AnneeService(AnneeRepo anneeRepo) {
		this.anneeRepo = anneeRepo;
	}
	
	public List<Annee> getAnneeWithout(int annee){
		return this.anneeRepo.listAnnees(annee);
	}
	
	public List<Annee> getAnnees(){
		return this.anneeRepo.findAll();
	}

}
