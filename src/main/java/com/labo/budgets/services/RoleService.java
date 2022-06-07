package com.labo.budgets.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labo.budgets.models.Laboratoire;
import com.labo.budgets.models.Utilisateur;
import com.labo.budgets.repositories.LaboratoireRepo;
import com.labo.budgets.repositories.RoleRepo;
import com.labo.budgets.repositories.UtilisateurRepo;

@Service
public class RoleService {
	
	private RoleRepo roleRepo;
	private LaboratoireRepo laboratoireRepo;
	private UtilisateurRepo utilisateurRepo;
	
	public RoleService(@Autowired RoleRepo roleRepo, @Autowired LaboratoireRepo laboratoireRepo, @Autowired UtilisateurRepo utilisateurRepo) {
		this.roleRepo = roleRepo;
		this.laboratoireRepo = laboratoireRepo;
		this.utilisateurRepo = utilisateurRepo;
	}
	
	//public List<Object[]>getUsersByRole(String role){
		//this.roleRepo.usersByRole(role);
		//List<Laboratoire> labos = this.laboratoireRepo.findAll();
		//return this.utilisateurRepo.findUsersWithLabosByRole(role);
		
	//}

}
