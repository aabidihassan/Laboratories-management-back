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
public class TypeBesoin {

    @Id
    @Column(length = 10)
    private String libelle;
    @OneToMany(mappedBy = "typeBesoin") @JsonIgnore
    private List<Besoin> besoins = new ArrayList<>();

}
