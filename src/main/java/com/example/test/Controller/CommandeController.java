package com.example.test.Controller;


import com.example.test.Entity.Commande;
import com.example.test.Service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Commandes")
public class CommandeController {



    @Autowired
    private CommandeService commandeService;

    @GetMapping("/")
    public List<Commande> getAllCommandes() {
        return commandeService.getAllCommandes();
    }

    @GetMapping("/{id}")
    public Commande getCommandeByID(@PathVariable("id") long id) {
       return commandeService.getCommandeByID(id);
    }

    @PostMapping("/addCommande")
    public Commande addCommande(@RequestBody Commande commande) {
       return commandeService.addCommande(commande);
    }
}
