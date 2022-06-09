package com.labo.budgets.repositories;

import com.labo.budgets.models.Annee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.time.Year;

@Repository
@RepositoryRestResource
public interface AnneeRepo extends JpaRepository<Annee, Integer> {
}
