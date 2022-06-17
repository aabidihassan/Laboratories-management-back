package com.labo.budgets.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.labo.budgets.dto.AffectRoleToUserDto;
import com.labo.budgets.models.Besoin;
import com.labo.budgets.models.BudgetPersonnel;
import com.labo.budgets.services.BesoinService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/besoins")
public class BesoinController {
	
	private BesoinService besoinService;
	
	@Autowired
	public BesoinController(BesoinService besoinService) {
		this.besoinService = besoinService;
	}
	
	@PostMapping("/")
	@PreAuthorize("hasAuthority('RESPO') or hasAuthority('USER')")
    public Besoin create(@RequestBody Besoin besoin){
        return this.besoinService.save(besoin);
    }
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('RESPO') or hasAuthority('USER')")
    public List<Besoin> getByBp(@PathVariable(name = "id") int id){
        BudgetPersonnel pb = new BudgetPersonnel();
        pb.setId_budget_personnel(id);
        return this.besoinService.getByBp(pb);
    }

}
