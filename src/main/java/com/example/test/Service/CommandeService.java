package com.example.test.Service;


import com.example.test.Entity.Commande;
import com.example.test.Entity.Produit;
import com.example.test.Repository.CommandeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeService {

    @Autowired
    private CommandeRepo commandeRepo;


    public List<Commande> getAllCommandes() {
        return this.commandeRepo.findAll();
    }

    public Commande getCommandeByID(long id) {
        return this.commandeRepo.findById(id).orElseThrow();
    }

    public Commande addCommande(Commande commande) {
        List<Produit> produits = commande.getProduits();
        for (Produit produit : produits) {
            Integer quantite = produit.getQuantite();
            produit.setQuantite(quantite - 1);
        }
        return commandeRepo.save(commande);
    }
}
