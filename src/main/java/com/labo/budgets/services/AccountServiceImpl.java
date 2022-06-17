package com.labo.budgets.services;

import com.labo.budgets.models.AppRole;
import com.labo.budgets.models.Utilisateur;
import com.labo.budgets.repositories.LaboratoireRepo;
import com.labo.budgets.repositories.RoleRepo;
import com.labo.budgets.repositories.UtilisateurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountServiceImpl{

    private RoleRepo roleRepo;
    private UtilisateurRepo utilisateurRepo;
    private PasswordEncoder passwordEncoder;
    private LaboratoireRepo laboratoireRepo;

    public AccountServiceImpl(RoleRepo roleRepo, UtilisateurRepo utilisateurRepo,PasswordEncoder passwordEncoder, LaboratoireRepo laboratoireRepo){
        this.roleRepo = roleRepo;
        this.utilisateurRepo = utilisateurRepo;
        this.passwordEncoder = passwordEncoder;
        this.laboratoireRepo = laboratoireRepo;
    }

    public Utilisateur addNewUser(Utilisateur user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return utilisateurRepo.save(user);
    }

    public AppRole addNewRole(AppRole role) {
        return roleRepo.save(role);
    }

    public void affectRoleToUser(String username, String role) {
        Utilisateur user = utilisateurRepo.findByUsername(username);
        AppRole role1 = roleRepo.findByLibelle(role);
        user.getRoles().add(role1);
        role1.getUsers().add(user);
    }

    public Utilisateur loadUserByUsername(String username) {
        return utilisateurRepo.findByUsername(username);
    }

    public List<Utilisateur> listUsers() {
        return utilisateurRepo.findAll();
    }
    
    public List<Utilisateur> getLaboUsers(String username){
    	return this.laboratoireRepo.findLabosByUser(this.loadUserByUsername(username)).getMembres();
    }
    
    public Utilisateur createUser(String username, Utilisateur user) {
    	user.setLabo(this.laboratoireRepo.findLabosByUser(this.loadUserByUsername(username)));
    	user = this.addNewUser(user);
    	this.affectRoleToUser(user.getUsername(), "USER");
    	return user;
    }
    
    public Utilisateur save(Utilisateur user) {
    	return this.utilisateurRepo.save(user);
    }
}
