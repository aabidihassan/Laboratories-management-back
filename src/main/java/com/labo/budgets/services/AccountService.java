package com.labo.budgets.services;

import com.labo.budgets.models.AppRole;
import com.labo.budgets.models.Utilisateur;

import java.util.List;

public interface AccountService {
    Utilisateur addNewUser(Utilisateur user);
    AppRole addNewRole(AppRole role);
    void affectRoleToUser(String username, String role);
    Utilisateur loadUserByUsername(String username);
    List<Utilisateur> listUsers();
}
