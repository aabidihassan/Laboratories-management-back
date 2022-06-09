package com.labo.budgets.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.labo.budgets.exception.ResourceNotFoundException;
import com.labo.budgets.models.Besoin;
import com.labo.budgets.repositories.BesoinRepo;


public class BesoinController {

	 @Autowired
	    private BesoinRepo br;
	 

	 
	   @GetMapping("/besoins")
	    public List<Besoin> getAllBesoins() {
		   List<Besoin> data = new ArrayList<>();
		   br.findAll().forEach(data::add);
	        return data;
	    }
	   
	   

	   

	    @GetMapping("/besoins/{id}")
	    public Besoin getBesoinById(@PathVariable(value = "id") Long id)
	        throws ResourceNotFoundException {
	    	return br.findById(id).get();
	
	    }
	    
	    @PostMapping("/besoins")
	    public Besoin createBesoin( @RequestBody Besoin Besoin) {
	        return br.save(Besoin);
	    }

	    @PutMapping("/besoins/{id}")
	    public Besoin updateBesoin(@PathVariable(value = "id") Long id,
	          @RequestBody Besoin b) throws ResourceNotFoundException {
	    	b.setId_besoin(id);
	    	return br.save(b);
	    	
	    }

	    @DeleteMapping("/besoins/{id}")
	    public void delete(@PathVariable(name="id") Long id) {
	    	br.deleteById(id);
	    }
	 
}
