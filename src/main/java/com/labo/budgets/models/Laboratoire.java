package com.labo.budgets.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Laboratoire {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id_labo;
    private String nom;
    private String adresse;
    private String telephone;
    @OneToMany(mappedBy = "labo") @JsonIgnore
    private List<Budget> budgets = new ArrayList<>();
    @OneToMany(mappedBy = "labo")
    private List<Utilisateur> membres = new ArrayList<>();
    

}
