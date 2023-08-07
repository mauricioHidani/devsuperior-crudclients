package com.devsuperior.challenges.crudclients.services;

import com.devsuperior.challenges.crudclients.dtos.ClientDTO;
import com.devsuperior.challenges.crudclients.entities.Client;
import com.devsuperior.challenges.crudclients.repositories.ClientRepository;
import com.devsuperior.challenges.crudclients.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    @Autowired private ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Client result = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente inexistente"));
        return new ClientDTO(result);
    }

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable) {
        Page<ClientDTO> result = clientRepository
                .findAll(pageable)
                .map(ClientDTO::new);

        if (result.isEmpty()) {
            throw new ResourceNotFoundException("Clientes inexistentes");
        }
        return result;
    }
}
