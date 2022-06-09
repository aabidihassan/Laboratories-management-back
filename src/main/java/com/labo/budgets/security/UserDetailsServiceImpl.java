package com.labo.budgets.security;

import com.labo.budgets.models.Utilisateur;
import com.labo.budgets.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    public AccountService accountService;
    public UserDetailsServiceImpl(@Autowired AccountService accountService){
        this.accountService = accountService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utilisateur user = accountService.loadUserByUsername(username);
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(appRole -> {
            authorities.add(new SimpleGrantedAuthority(appRole.getLibelle()));
        });
        return new User(user.getUsername(), user.getPassword(), authorities);
    }
}
