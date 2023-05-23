package com.example.test.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "table_client")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client", nullable = false)
    private long id;
   @Column(length = 255 ,nullable = false)
    private String nom;
    @Column(length = 255 ,nullable = false)
    private  String prenom;
    @Column(length = 255 ,nullable = false)
    private String email;
    @Column(length = 255 ,nullable = false)
    private String mot_de_passe;
    @Enumerated(EnumType.STRING)
    private Role role;


    @OneToOne
    @JoinColumn(name = "commande_id")
    private Commande commande;
}
