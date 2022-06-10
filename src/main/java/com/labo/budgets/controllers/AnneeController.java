package com.labo.budgets.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.labo.budgets.models.Annee;
import com.labo.budgets.services.AnneeService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/annees")
public class AnneeController {
	
	private AnneeService anneeService;
	
	@Autowired
	public AnneeController(AnneeService anneeService) {
		this.anneeService = anneeService;
	}
	
	@GetMapping("/listanneeswithout/{annee}")
    @PreAuthorize("hasAuthority('RESPO')")
	public List<Annee> getUserswithout(@PathVariable(name="annee") int annee) {
		return this.anneeService.getAnneeWithout(annee);
	}
	
	@GetMapping("/")
    @PreAuthorize("hasAuthority('RESPO')")
	public List<Annee> getAnnees() {
		return this.anneeService.getAnnees();
	}

}
