package com.example.invoice_generator.controller;

import com.example.invoice_generator.config.ApiResponse;
import com.example.invoice_generator.dto.ClientDTO;
import com.example.invoice_generator.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/clients")
@Tag(name = "Clients" , description = "Manage Clients")
public class ClientController {

    private final ClientService clientService;

    // 🟢 Create Client
    @PostMapping
    public ResponseEntity<ApiResponse<ClientDTO>> createClient(@RequestBody ClientDTO clientDTO){
        ClientDTO createdClient = clientService.createClient(clientDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiResponse.<ClientDTO>builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.CREATED.value())
                        .message("Client created successfully 🎉")
                        .data(createdClient)
                        .build()
        );
    }

    // 🟢 Get all clients
    @Operation(
            summary = "Get all clients" ,
            description = "Returns a list of clients in the system ." ,
            responses = {
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(
                            responseCode = "200" ,
                            description = "List of clients is retrieve successfully !"
                    )
            }
    )
    @GetMapping
    public ResponseEntity<ApiResponse<List<ClientDTO>>> getAllClients(){
        List<ClientDTO> clients = clientService.getAllClients();
        return ResponseEntity.ok(
                ApiResponse.<List<ClientDTO>>builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.OK.value())
                        .message(clients.isEmpty() ? "No clients found ⚠️" : "Clients fetched successfully ✅")
                        .data(clients)
                        .build()
        );
    }

    // 🟢 Get client by id
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ClientDTO>> getClientById(@PathVariable Long id){
        ClientDTO client = clientService.getClientById(id);
        return ResponseEntity.ok(
                ApiResponse.<ClientDTO>builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.OK.value())
                        .message("Client fetched successfully ✅")
                        .data(client)
                        .build()
        );
    }

    // 🟠 Update client
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ClientDTO>> updateClient(@PathVariable Long id ,@RequestBody ClientDTO clientDTO){
        ClientDTO updatedClient = clientService.updateClient(id,clientDTO);
        return ResponseEntity.ok(
                ApiResponse.<ClientDTO>builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.OK.value())
                        .message("Client updated successfully ✏️")
                        .data(updatedClient)
                        .build()
        );
    }

    // 🔴 Delete client
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteClient(@PathVariable Long id){
        clientService.deleteClient(id);
        return ResponseEntity.ok(
                ApiResponse.<Void>builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.OK.value())
                        .message("Client deleted successfully 🗑️")
                        .data(null)
                        .build()
        );
    }
}
