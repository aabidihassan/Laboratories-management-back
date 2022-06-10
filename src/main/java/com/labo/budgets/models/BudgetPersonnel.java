package com.labo.budgets.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class BudgetPersonnel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_budget_personnel;
    @ManyToOne @JsonIgnore
    private Utilisateur utilisateur;
    @ManyToOne @JsonIgnore
    private Budget budget;
    private double montant;

}
