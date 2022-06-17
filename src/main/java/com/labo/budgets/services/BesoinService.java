package com.labo.budgets.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labo.budgets.models.Besoin;
import com.labo.budgets.models.BudgetPersonnel;
import com.labo.budgets.repositories.BesoinRepo;

@Service
public class BesoinService {
	
	private BesoinRepo besoinRepo;
	
	@Autowired
	public BesoinService(BesoinRepo besoinRepo) {
		this.besoinRepo = besoinRepo;
	}
	
	public Besoin save(Besoin besoin) {
		return this.besoinRepo.save(besoin);
	}
	
	public List<Besoin> listBesoins(){
		return this.besoinRepo.findAll();
	}
	
	public List<Besoin> getByBp(BudgetPersonnel bp){
		return this.besoinRepo.findByPudgetPersonnel(bp);
	}

}
