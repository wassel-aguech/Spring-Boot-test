package com.example.test.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "table_commande")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_commande" , nullable = false)
    private Long id;
    @Column(length = 255, nullable = false)
    private double prix_total_vente;

    @OneToOne
    private Client client;
    @OneToMany(mappedBy = "Commande")
    private List<Produit> produits;



}
