package com.labo.budgets.services;

import com.labo.budgets.models.AppRole;
import com.labo.budgets.models.Utilisateur;
import com.labo.budgets.repositories.RoleRepo;
import com.labo.budgets.repositories.UtilisateurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private RoleRepo roleRepo;
    private UtilisateurRepo utilisateurRepo;
    private PasswordEncoder passwordEncoder;

    public AccountServiceImpl(@Autowired RoleRepo roleRepo, @Autowired UtilisateurRepo utilisateurRepo, @Autowired PasswordEncoder passwordEncoder){
        this.roleRepo = roleRepo;
        this.utilisateurRepo = utilisateurRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Utilisateur addNewUser(Utilisateur user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return utilisateurRepo.save(user);
    }

    @Override
    public AppRole addNewRole(AppRole role) {
        return roleRepo.save(role);
    }

    @Override
    public void affectRoleToUser(String username, String role) {
        Utilisateur user = utilisateurRepo.findByUsername(username);
        AppRole role1 = roleRepo.findByLibelle(role);
        user.getRoles().add(role1);
        role1.getUsers().add(user);
    }

    @Override
    public Utilisateur loadUserByUsername(String username) {
        return utilisateurRepo.findByUsername(username);
    }

    @Override
    public List<Utilisateur> listUsers() {
        return utilisateurRepo.findAll();
    }
}
