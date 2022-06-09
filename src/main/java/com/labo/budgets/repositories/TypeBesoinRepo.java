package com.labo.budgets.repositories;

import com.labo.budgets.models.TypeBesoin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource
public interface TypeBesoinRepo extends JpaRepository<TypeBesoin, String> {
}
