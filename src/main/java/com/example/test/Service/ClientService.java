package com.example.test.Service;


import com.example.test.Entity.Client;
import com.example.test.Repository.ClientRepo;
import com.example.test.Response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {


    @Autowired
    private ClientRepo clientRepo;


public List<Client> getAllClients(){
    return this.clientRepo.findAll();
    }

    public Client getClientByID(long id) {
        return this.clientRepo.findById(id).orElseThrow();
    }

    public Client addClient(Client client) {
        return this.clientRepo.save(client);
    }

    public Client  findByEmail(String email) {
        return this.clientRepo.findByEmail(email).orElseThrow();
    }

    public Boolean existsByEmail(String email) {
        return this.clientRepo.existsByEmail(email);
    }

    public ResponseEntity<MessageResponse> updateClientByID(long id, Client client) {
        Optional<Client> optionalClient = clientRepo.findById(id);
        if (optionalClient.isPresent()) {
            Client editedClient = optionalClient.get();
            editedClient.setNom(client.getNom());
            editedClient.setPrenom(client.getPrenom());
            editedClient.setEmail(client.getEmail());
            editedClient.setMot_de_passe(client.getMot_de_passe());
            editedClient.setCommande(client.getCommande());

            clientRepo.save(editedClient);
            MessageResponse messageResponse = new MessageResponse("Client Updated successfully !!!!!!! ");

            return ResponseEntity.ok(messageResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<MessageResponse> deleteClientById(long id) {
        Optional<Client> client = clientRepo.findById(id);
        if (client.isPresent()) {
            clientRepo.deleteById(id);
            MessageResponse messageResponse = new MessageResponse("Client Deleted Successfully !!!!!!!!");
            return ResponseEntity.ok(messageResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
