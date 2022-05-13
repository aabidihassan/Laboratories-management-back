package com.labo.budgets;

import com.labo.budgets.models.AppRole;
import com.labo.budgets.models.Utilisateur;
import com.labo.budgets.services.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class LaboratoryBudgetsManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(LaboratoryBudgetsManagementApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner start(AccountService accountService){
        return args -> {
            accountService.addNewRole(new AppRole("ADMIN"));
            accountService.addNewRole(new AppRole("USER"));
            accountService.addNewUser(new Utilisateur("hassan", "hassan", new ArrayList<>()));
            accountService.addNewUser(new Utilisateur("aabidi", "hassan", new ArrayList<>()));
            accountService.addNewUser(new Utilisateur("hassanaabidi", "hassan", new ArrayList<>()));
            accountService.affectRoleToUser("hassan", "ADMIN");
            accountService.affectRoleToUser("aabidi", "USER");
            accountService.affectRoleToUser("hassanaabidi", "USER");
            accountService.affectRoleToUser("hassanaabidi", "ADMIN");

        };
    }

}
