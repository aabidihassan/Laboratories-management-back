package com.labo.budgets.repositories;

import com.labo.budgets.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
public interface UtilisateurRepo extends JpaRepository<Utilisateur, String> {

    Utilisateur findByUsername(String username);

}
