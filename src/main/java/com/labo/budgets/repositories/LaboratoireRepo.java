package com.labo.budgets.repositories;

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
public interface LaboratoireRepo extends JpaRepository<Laboratoire, Long> {
	
	//List<Laboratoire> findAllLaboratoiresByMembres(List<Utilisateur> list);
	
	@Query("select l from Laboratoire l where :user in elements(l.membres)")
	Laboratoire findLabosByUser(@Param("user") Utilisateur user);

}
