package com.example.test.Controller;

import com.example.test.Entity.Client;
import com.example.test.Response.MessageResponse;
import com.example.test.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/findByEmail")
    public Client findByEmail(String email){
       return this.clientService.findByEmail(email);
    }

    @GetMapping("/existsByEmail")
    public Boolean existsByEmail(String email){
        return this.clientService.existsByEmail(email);
    }

    @GetMapping("/")
    public List<Client> getAllClients(){
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    public Client getClientByID(@PathVariable("id") long id){
        return clientService.getClientByID(id);
    }

    @PostMapping("/addClient")
    public Client addClient(@RequestBody Client client){
        return clientService.addClient(client);
    }

    @PutMapping("/updateClient/{id}")
    public ResponseEntity<MessageResponse> updateClientByID(@PathVariable("id") long id, @RequestBody Client client){
        ResponseEntity<MessageResponse> response = clientService.updateClientByID(id, client);
        return response;
    }
    @DeleteMapping("/deleteClient/{id}")
    public ResponseEntity<MessageResponse> deleteClientById(@PathVariable("id") long id){
        ResponseEntity<MessageResponse> response = clientService.deleteClientById(id);
        return response;
    }



}
