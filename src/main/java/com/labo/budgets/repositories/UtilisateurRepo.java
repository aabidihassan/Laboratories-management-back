package com.labo.budgets.repositories;

import com.labo.budgets.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepo extends JpaRepository<Utilisateur, String> {

    Utilisateur findByUsername(String username);

}
