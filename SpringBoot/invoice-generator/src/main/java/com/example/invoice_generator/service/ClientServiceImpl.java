package com.example.invoice_generator.service;

import com.example.invoice_generator.dto.ClientDTO;
import com.example.invoice_generator.entity.Client;
import com.example.invoice_generator.mapper.ClientMapper;
import com.example.invoice_generator.repository.ClientRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service @RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public ClientDTO createClient(ClientDTO clientDTO) {
        Client client = ClientMapper.clientDtoToEntity(clientDTO);
        return ClientMapper.clientToDTO(clientRepository.save(client));
    }

    @Override
    public List<ClientDTO> getAllClients() {
        return clientRepository
                .findAll()
                .stream()
                .map(ClientMapper::clientToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ClientDTO getClientById(Long id) {
        return clientRepository
                .findById(id)
                .map(ClientMapper::clientToDTO)
                .orElseThrow(() -> new RuntimeException("Client not found !!"));
    }

    @Override
    public ClientDTO updateClient(Long id, ClientDTO clientDTO) {
        return clientRepository.findById(id)
                .map(existingClient -> {
                    existingClient.setName(clientDTO.getName());
                    existingClient.setEmail(clientDTO.getEmail());
                    existingClient.setAddress(clientDTO.getAddress());
                    existingClient.setPhone(clientDTO.getPhone());
                    Client updated = clientRepository.save(existingClient);
                    return ClientMapper.clientToDTO(updated);
                })
                .orElseThrow(() -> new RuntimeException("Client not found with id: " + id));
    }

    @Override
    public void deleteClient(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new RuntimeException("Client not found with id: " + id);
        }
        clientRepository.deleteById(id);
    }

}
