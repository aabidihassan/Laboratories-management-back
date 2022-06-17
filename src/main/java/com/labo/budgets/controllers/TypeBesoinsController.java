package com.labo.budgets.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.labo.budgets.models.TypeBesoin;
import com.labo.budgets.models.Utilisateur;
import com.labo.budgets.services.TypeBesoinService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/types")
public class TypeBesoinsController {
	
	private TypeBesoinService typeBesoinService;
	
	@Autowired
	public TypeBesoinsController(TypeBesoinService typeBesoinService) {
		this.typeBesoinService = typeBesoinService;
	}
	
	@GetMapping(path = "/")
    @PreAuthorize("hasAuthority('RESPO') or hasAuthority('USER')")
    public List<TypeBesoin> getAll(){
    	return this.typeBesoinService.findAll();
    }

}
