package com.labo.budgets.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labo.budgets.models.TypeBesoin;
import com.labo.budgets.repositories.TypeBesoinRepo;

@Service
public class TypeBesoinService {
	
	private TypeBesoinRepo typeBesoinRepo;
	
	@Autowired
	public TypeBesoinService(TypeBesoinRepo typeBesoinRepo) {
		this.typeBesoinRepo = typeBesoinRepo;
	}
	
	public List<TypeBesoin> findAll(){
		return this.typeBesoinRepo.findAll();
	}

}
