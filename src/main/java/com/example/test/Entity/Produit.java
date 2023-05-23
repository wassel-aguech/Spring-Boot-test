package com.example.test.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "table_produit")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Produit {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id_produit", nullable = false)
     private long id;
    @Column(length = 255 ,nullable = false)
    private String nom;
    @Column(length = 255 ,nullable = false)
    private String description;
    @Column(length = 255 ,nullable = false)
    private int quantite;
    @Column(length = 255 ,nullable = false)
    private  double prix;


    @ManyToOne
    @JoinColumn(name = "commande_id")
    private Commande commande;
}
