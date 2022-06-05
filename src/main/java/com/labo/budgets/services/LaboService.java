package com.labo.budgets.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labo.budgets.models.Laboratoire;
import com.labo.budgets.repositories.LaboratoireRepo;

@Service
public class LaboService {
	
	private LaboratoireRepo laboratoireRepo;
	
	public LaboService(@Autowired LaboratoireRepo laboratoireRepo) {
		this.laboratoireRepo = laboratoireRepo;
	}
	
	public List<Laboratoire> getAllLabos(){
		return this.laboratoireRepo.findAll();
	}
	
	public Laboratoire getLaboById(long id) {
		return this.laboratoireRepo.findById(id).get();
	}
	
	public Laboratoire saveLabo(Laboratoire labo) {
		return this.laboratoireRepo.save(labo);
	}

}
