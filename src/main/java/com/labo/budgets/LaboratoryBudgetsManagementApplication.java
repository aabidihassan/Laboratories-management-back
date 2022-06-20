package com.labo.budgets;

import com.labo.budgets.models.*;
import com.labo.budgets.repositories.AnneeRepo;
import com.labo.budgets.repositories.BudgetRepo;
import com.labo.budgets.repositories.LaboratoireRepo;
import com.labo.budgets.services.AccountServiceImpl;
import com.labo.budgets.services.BudgetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.Calendar;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
@CrossOrigin(origins = "*")
@EnableScheduling
public class LaboratoryBudgetsManagementApplication {
	
	@Autowired
	private AnneeRepo anneeRepo;

    public static void main(String[] args) {
        SpringApplication.run(LaboratoryBudgetsManagementApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    @Scheduled(cron = "0 1 0 1 1 *")
    public void task() {
        this.anneeRepo.save(new Annee(Calendar.getInstance().get(Calendar.YEAR), null));
    }

    @Bean
    CommandLineRunner start(AccountServiceImpl accountService, LaboratoireRepo laboratoireRepo, BudgetService budgetService, AnneeRepo anneeRepo){
        return args -> {

            Laboratoire labo = new Laboratoire();
            labo.setId_labo(1);
            labo.setAdresse("Gueliz Marrakech");
            labo.setNom("Labo number 1");
            labo.setTelephone("0666666666");
            laboratoireRepo.save(labo);

            anneeRepo.save(new Annee(2020, new ArrayList<>()));

            Budget budget = new Budget();
            budget.setAnnee(new Annee(2020, null));
            budget.setDb(5000);
            budget.setLabo(labo);
            budget.setDr(7000);
            budgetService.newBudget(labo.getNom(), budget);

            accountService.addNewRole(new AppRole("ADMIN"));
            accountService.addNewRole(new AppRole("USER"));
            accountService.addNewRole(new AppRole("RESPO"));
            accountService.addNewUser(new Utilisateur("respo", "respo", "respo@gmail.com", "Respo adresse", "0637842698", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), labo));
            accountService.addNewUser(new Utilisateur("admin", "admin", "admin@gmail.com", "Admin adresse", "0637842698", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), null));
            accountService.addNewUser(new Utilisateur("user", "user", "user@gmail.com", "User adresse", "0637842698", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), labo));
            accountService.affectRoleToUser("admin", "ADMIN");
            accountService.affectRoleToUser("user", "USER");
            accountService.affectRoleToUser("respo", "RESPO");

        };
    }

}
