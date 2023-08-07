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

    @Transactional
    public ClientDTO insert(ClientDTO client) {
        Client saved = clientRepository.save(client.toEntity());
        return new ClientDTO(saved);
    }

    @Transactional
    public ClientDTO updateById(Long id, ClientDTO client) {
        try {
            Client result = clientRepository.getReferenceById(id);
            result = clientRepository.save(client.copy(result));
            return new ClientDTO(result);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Cliente inexistente");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void deleteById(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new ResourceNotFoundException("Cliente inexistente");
        }
        clientRepository.deleteById(id);
    }
}
