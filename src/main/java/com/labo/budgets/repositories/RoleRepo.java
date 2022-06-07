package com.labo.budgets.repositories;

import com.labo.budgets.models.AppRole;
import com.labo.budgets.models.Utilisateur;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource
public interface RoleRepo extends JpaRepository<AppRole, String> {

    AppRole findByLibelle(String libelle);
    
    @Query("select u from AppRole r join r.users u where r.libelle=:abc")
	List<Utilisateur> usersByRole(@Param("abc") String libelle);

}
