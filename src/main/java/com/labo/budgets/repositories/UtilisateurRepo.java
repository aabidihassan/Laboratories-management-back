package com.labo.budgets.repositories;

import com.labo.budgets.models.AppRole;
import com.labo.budgets.models.Laboratoire;
import com.labo.budgets.models.Utilisateur;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
public interface UtilisateurRepo extends JpaRepository<Utilisateur, String> {

    Utilisateur findByUsername(String username);
    
    //@Query("select u from Utilisateur u join u.labo l join u.roles r where r.libelle=:abc group by u.username")
    //List<Utilisateur> findUsersWithLabosByRole(@Param("abc") String libelle);
    
    //List<Utilisateur> findAllUtilisateursByRoles(List<AppRole> list);
    
    //List<?> findAllByRoles(List<AppRole> list);
    
    //List<Utilisateur> findByRoles(List<AppRole> roles);

}
