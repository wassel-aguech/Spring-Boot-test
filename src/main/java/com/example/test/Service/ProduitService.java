package com.example.test.Service;

import com.example.test.Entity.Produit;
import com.example.test.Repository.ProduitRepo;
import com.example.test.Response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {


    @Autowired
    private ProduitRepo produitRepo;


    public List<Produit> getAllProduits() {
        return this.produitRepo.findAll();
    }

    public Produit getProduitByID(long id) {
        return this.produitRepo.findById(id).orElseThrow();
    }

    public Produit addProduit(Produit produit) {
        return this.produitRepo.save(produit);
    }

    public ResponseEntity<MessageResponse> updateProduitByID(long id, Produit produit) {
        Optional<Produit> optionalProduit = produitRepo.findById(id);
        if (optionalProduit.isPresent()) {
            Produit editedProduit = optionalProduit.get();

            editedProduit.setNom(produit.getNom());
            editedProduit.setDescription(produit.getDescription());
            editedProduit.setQuantite(produit.getQuantite());
            editedProduit.setPrix(produit.getPrix());
            editedProduit.setCommande(produit.getCommande());

            produitRepo.save(editedProduit);
            MessageResponse messageResponse = new MessageResponse("Product Updated successfully !!!!!!");

            return ResponseEntity.ok(messageResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



    public ResponseEntity<MessageResponse> deleteProduitById(long id) {
        Optional<Produit> optionalProduit = produitRepo.findById(id);
        if (optionalProduit.isPresent()) {
            produitRepo.deleteById(id);
            MessageResponse messageResponse = new MessageResponse("Product Deleted Successfully !!!!!!!!");
            return ResponseEntity.ok(messageResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
