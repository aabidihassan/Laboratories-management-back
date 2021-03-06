package com.labo.budgets.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Besoin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_besoin;
    private String description;
    private double montant;
    @ManyToOne
    private TypeBesoin typeBesoin;
    @ManyToOne @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Utilisateur utilisateur;
    @ManyToOne
    private BudgetPersonnel pudgetPersonnel;

}
