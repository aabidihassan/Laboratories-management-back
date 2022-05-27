package com.labo.budgets.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_budget;
    private double db;
    private double dr;
    @ManyToOne
    private Annee annee;
    @ManyToOne
    private Laboratoire labo;
    @OneToMany(mappedBy = "budget")
    private List<BudgetPersonnel> budgetPersonnels = new ArrayList<>();

}
