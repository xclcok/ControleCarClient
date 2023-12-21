package com.client.app.controller;


import com.client.app.entities.Client;
import com.client.app.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/clients")
    public List<Client> findAll(){
        return clientService.findAll();
    }

    @GetMapping("/{id}")
    public Client findById(@PathVariable Long id) throws Exception{
        return clientService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody Client client){
        clientService.addClient(client);

    }
}
