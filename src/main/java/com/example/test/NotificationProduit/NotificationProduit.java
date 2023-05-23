package com.example.test.NotificationProduit;

import com.example.test.Entity.Produit;
import com.example.test.Repository.ProduitRepo;
import com.example.test.Service.SendMailService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class NotificationProduit {

    @Autowired
    private SendMailService sendMailService;
    private ProduitRepo produitRepo;
    public void sendMailProduit() {
        List<Produit> produits = produitRepo.findAll();
        for (Produit produit : produits) {
            if (produit.getQuantite()<10){
           sendMailService.sendEmail(
            "admin_stock@gmail.com",
            "quantite proquit presque fini ",
            "Salut monsieur l'administrateur   de stock le produit "
                    + produit.getNom() +" avec ID"
                    + produit.getId() + " est de quantite inferieure a 10");
        }
        }
    }



}
