package com.labo.budgets.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Utilisateur {

    @Id
    @Column(length = 30)
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String email;
    private String adresse;
    private String telephone;
    @ManyToMany(fetch = FetchType.EAGER)
    List<AppRole> roles = new ArrayList<>();
    @OneToMany(mappedBy = "utilisateur")
    private List<Besoin> besoins = new ArrayList<>();
    @OneToMany(mappedBy = "utilisateur")
    List<BudgetPersonnel> budgetPersonnels = new ArrayList<>();
    @ManyToOne
    private Laboratoire labo;


    public Utilisateur(String username, String password, List<AppRole> roles){
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

}
