package com.labo.budgets.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.labo.budgets.security.JwtUtil;
import com.labo.budgets.services.AccountServiceImpl;
import com.labo.budgets.dto.AffectRoleToUserDto;
import com.labo.budgets.models.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/users")
public class AccountRestController {

    private AccountServiceImpl accountService;

    @Autowired
    public AccountRestController(AccountServiceImpl accountService){
        this.accountService = accountService;
    }
    
    @GetMapping("/")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<Utilisateur> getUsers(){
    	return this.accountService.listUsers();
    }

    @PostMapping("roletouser")
    @PostAuthorize("hasAnyAuthority('ADMIN')")
    public void affectRoleToUser(@RequestBody AffectRoleToUserDto affectRoleToUserDto){
        this.accountService.affectRoleToUser(affectRoleToUserDto.getUsername(), affectRoleToUserDto.getRole());
    }

    @GetMapping(path = "/profile")
    //@PostAuthorize("hasAnyAuthority('RESPO', 'ADMIN', 'USER')")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('RESPO') or hasAuthority('USER')")
    public Utilisateur profile(Principal principal){
        return accountService.loadUserByUsername(principal.getName());
    }
    
    @GetMapping(path = "/userswithsamelabo/{username}")
    @PreAuthorize("hasAuthority('RESPO')")
    public List<Utilisateur> userswithsamelabo(@PathVariable(name="username") String username){
    	return this.accountService.getLaboUsers(username);
    }
    
    @PostMapping("/newuser/{respo}")
    @PreAuthorize("hasAuthority('RESPO')")
    public Utilisateur newuser(@PathVariable(name="respo") String respo,@RequestBody Utilisateur utilisateur) {
    	System.out.println(respo);
    	return this.accountService.createUser(respo, utilisateur);
    }

}
