package com.labo.budgets.repositories;

import com.labo.budgets.models.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<AppRole, String> {

    AppRole findByLibelle(String libelle);

}
