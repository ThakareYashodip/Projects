package com.example.invoice_generator.mapper;

import com.example.invoice_generator.dto.ClientDTO;
import com.example.invoice_generator.entity.Client;
import org.springframework.stereotype.Component;

public class ClientMapper {

    public static ClientDTO clientToDTO(Client client){
        return new ClientDTO(
                client.getId(),
                client.getName(),
                client.getEmail(),
                client.getAddress(),
                client.getPhone()
        );
    }

    public static Client clientDtoToEntity(ClientDTO clientDTO){
        Client client = new Client();
        client.setId(clientDTO.getId());
        client.setName(clientDTO.getName());
        client.setPhone(clientDTO.getPhone());
        client.setEmail(clientDTO.getEmail());
        client.setAddress(clientDTO.getAddress());

        return client ;
    }
}
