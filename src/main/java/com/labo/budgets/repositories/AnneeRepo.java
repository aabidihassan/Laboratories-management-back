package com.labo.budgets.repositories;

import com.labo.budgets.models.Annee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.time.Year;
import java.util.List;

@Repository
public interface AnneeRepo extends JpaRepository<Annee, Integer> {
	
	@Query("select a from Annee a where a.year<>:abc")
	List<Annee> listAnnees(@Param("abc") int year);
}
