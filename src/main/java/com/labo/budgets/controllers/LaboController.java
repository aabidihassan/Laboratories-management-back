package com.labo.budgets.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.labo.budgets.models.AppRole;
import com.labo.budgets.models.Laboratoire;
import com.labo.budgets.models.Utilisateur;
import com.labo.budgets.services.AccountService;
import com.labo.budgets.services.LaboService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/labos")
public class LaboController {
	
	private LaboService laboService;
	private AccountService accountService;
	
	public LaboController(@Autowired LaboService laboService, @Autowired AccountService accountService) {
		this.laboService = laboService;
		this.accountService = accountService;
	}
	
	@GetMapping("/labos")
	public List<Laboratoire> getLabos(){
		return this.laboService.getAllLabos();
	}
	
	@PostMapping("/newlabo")
	@PreAuthorize("hasAuthority('ADMIN')")
	public void newlabo(@RequestBody Utilisateur utilisateur) {
		this.accountService.addNewUser(utilisateur);
		this.accountService.affectRoleToUser(utilisateur.getUsername(), "RESPO");
	}
	
	@GetMapping("/usersByRole")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('RESPO')")
	public List<Laboratoire> getUsersByRole(@Param("role") String role){
		return this.laboService.labosWithUsersByRole(List.of(new AppRole(role)));
	}

}
