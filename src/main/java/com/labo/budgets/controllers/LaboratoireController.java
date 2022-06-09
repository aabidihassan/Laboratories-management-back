package com.labo.budgets.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.labo.budgets.exception.ResourceNotFoundException;
import com.labo.budgets.models.Laboratoire;
import com.labo.budgets.repositories.LaboratoireRepo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@CrossOrigin("*")
@RequestMapping("/api") 
public class LaboratoireController {


	 @Autowired
	    private LaboratoireRepo br;
	 

	 
	   @GetMapping("/labo")
	    public List<Laboratoire> getAllLaboratoires() {
		   List<Laboratoire> data = new ArrayList<>();
		   br.findAll().forEach(data::add);
	        return data;
	    }
	   
	   

	   

	    @GetMapping("/laboratoires/{id}")
	    public Laboratoire getLaboratoireById(@PathVariable(value = "id") Long id)
	        throws ResourceNotFoundException {
	    	return br.findById(id).get();
	
	    }
	    
	    @PostMapping("/laboratoires")
	    public Laboratoire createLaboratoire( @RequestBody Laboratoire Laboratoire) {
	        return br.save(Laboratoire);
	    }

	    @PutMapping("/laboratoires/{id}")
	    public Laboratoire updateLaboratoire(@PathVariable(value = "id") Long id,
	          @RequestBody Laboratoire b) throws ResourceNotFoundException {
	    	b.setId_labo(id);
	    	return br.save(b);
	    	
	    }

	    @DeleteMapping("/laboratoires/{id}")
	    public void delete(@PathVariable(name="id") Long id) {
	    	br.deleteById(id);
	    }
	 
}
