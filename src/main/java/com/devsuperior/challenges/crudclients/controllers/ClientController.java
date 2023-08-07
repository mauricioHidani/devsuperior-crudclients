package com.devsuperior.challenges.crudclients.controllers;

import com.devsuperior.challenges.crudclients.dtos.ClientDTO;
import com.devsuperior.challenges.crudclients.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired private ClientService clientService;

    @GetMapping("/{id}")
    private ResponseEntity<ClientDTO> findById(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(clientService.findById(id));
    }

    @GetMapping
    private ResponseEntity<Page<ClientDTO>> findAll(Pageable pageable) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(clientService.findAll(pageable));
    }

    @PostMapping
    public ResponseEntity<ClientDTO> insert(@Valid @RequestBody ClientDTO client) {
        ClientDTO result = clientService.insert(client);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(result.getId())
                .toUri();

        return ResponseEntity
                .created(uri)
                .body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO> udpateById(@PathVariable Long id, @Valid @RequestBody ClientDTO client) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(clientService.updateById(id, client));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        clientService.deleteById(id);
        return ResponseEntity
                .noContent()
                .build();
    }
}
