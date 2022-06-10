package com.labo.budgets.repositories;

import com.labo.budgets.models.Annee;
import com.labo.budgets.models.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import com.labo.budgets.models.Laboratoire;

@RepositoryRestResource
public interface BudgetRepo extends JpaRepository<Budget, Long> {
//    @RestResource(path = "/bylabo")
//    public List<Budget> findByLabo_Id_labo(@Param("labo") int labo);

	Budget findByLaboAndAnnee(Laboratoire labo, Annee annee);
	
}
