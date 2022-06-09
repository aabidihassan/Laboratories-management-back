package com.labo.budgets.repositories;

import com.labo.budgets.models.Laboratoire;
import org.springframework.data.domain.Page;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
@RepositoryRestResource
public interface LaboratoireRepo extends JpaRepository<Laboratoire, Long> {


	 @RestResource(path ="/byServiceLabo")
	    public List<Laboratoire> findByNomContains(@Param("b") String nom);
	    
	    @RestResource(path ="/byServiceLaboPage")
	    public Page<Laboratoire> findByNomContains(@Param("b") String nom,Pageable pageable);



}
