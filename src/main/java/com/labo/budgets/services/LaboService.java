package com.labo.budgets.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labo.budgets.models.AppRole;
import com.labo.budgets.models.Laboratoire;
import com.labo.budgets.models.Utilisateur;
import com.labo.budgets.repositories.LaboratoireRepo;
import com.labo.budgets.repositories.RoleRepo;
import com.labo.budgets.repositories.UtilisateurRepo;

@Service
public class LaboService {
	
	private LaboratoireRepo laboratoireRepo;
	private RoleRepo roleRepo;
	
	@Autowired
	public LaboService(LaboratoireRepo laboratoireRepo, RoleRepo roleRepo) {
		this.laboratoireRepo = laboratoireRepo;
		this.roleRepo = roleRepo;
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
	
	public List<Laboratoire> labosWithUsersByRole(List<AppRole> roles){
		
		List<Utilisateur> users = this.roleRepo.usersByRole(roles.get(0).getLibelle());
		List<Laboratoire> labos = new ArrayList<Laboratoire>();
		
		users.forEach(u->{
			Laboratoire labo = this.laboratoireRepo.findLabosByUser(u);
			labo.getMembres().clear();
			labo.setMembres(List.of(u));
			labos.add(labo);
		});
		
		return labos;
		
	}
	
	public Laboratoire loadLaboByUser(Utilisateur user) {
		return this.laboratoireRepo.findLabosByUser(user);
	}
	
	public Laboratoire loadLaboByUsername(String user) {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setUsername(user);
		return this.loadLaboByUser(utilisateur);
	}
	

}
