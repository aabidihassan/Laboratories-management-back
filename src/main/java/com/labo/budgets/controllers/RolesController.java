package com.labo.budgets.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.labo.budgets.models.Laboratoire;
import com.labo.budgets.models.Utilisateur;
import com.labo.budgets.services.LaboService;
import com.labo.budgets.services.RoleService;

@RestController
@RequestMapping("api/roles")
@CrossOrigin("*")
public class RolesController {
	
	private RoleService roleService;
	private LaboService laboService;
	
	@Autowired
	public RolesController(RoleService roleService, LaboService laboService) {
		this.roleService = roleService;
		this.laboService = laboService;
	}
	
	@GetMapping("/usersbyrole")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('RESPO')")
	public List<Laboratoire> usersByRole(@Param("role") String role) {
		return this.laboService.getAllLabos();
	}

}
