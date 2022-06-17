package com.labo.budgets.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class BudgetPersonnel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_budget_personnel;
    @ManyToOne @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Utilisateur utilisateur;
    @ManyToOne @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Budget budget;
    private double montant;
    @OneToMany(mappedBy = "pudgetPersonnel") @JsonIgnore
    private List<Besoin> besoins = new ArrayList<Besoin>();

}
