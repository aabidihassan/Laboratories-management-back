package com.labo.budgets.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class BudgetPersonnel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_budget_personnel;
    @ManyToOne()
    private Utilisateur utilisateur;
    @ManyToOne
    private Budget budget;

}
