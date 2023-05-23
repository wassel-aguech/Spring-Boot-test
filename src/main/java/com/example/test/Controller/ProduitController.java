package com.example.test.Controller;


import com.example.test.Entity.Produit;
import com.example.test.Response.MessageResponse;
import com.example.test.Service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Produits")
public class ProduitController {


@Autowired
    private ProduitService produitService;

    @GetMapping("/")
    public List<Produit> getAllProduits() {
        return produitService.getAllProduits();
    }


    @GetMapping("/{id}")
    public Produit getProduitByID(@PathVariable("id") long id) {
       return  produitService.getProduitByID(id);
    }

    @PostMapping("/addProduit")
    public Produit addNewProduit(@RequestBody Produit produit) {
       return produitService.addProduit(produit);
    }

    @PutMapping("/updateProduit/{id}")
    public ResponseEntity<MessageResponse> updateProduitByID(@PathVariable("id") long id, @RequestBody Produit produit) {
        ResponseEntity<MessageResponse> response = produitService.updateProduitByID(id, produit);
        return response;
    }

    @DeleteMapping("/deleteProduit/{id}")
    public ResponseEntity<MessageResponse> deleteProduitById(@PathVariable("id") long id) {
        ResponseEntity<MessageResponse> response = produitService.deleteProduitById(id);
        return response;
    }

}
