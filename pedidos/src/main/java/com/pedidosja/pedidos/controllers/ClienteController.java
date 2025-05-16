package com.pedidosja.pedidos.controllers;

import com.pedidosja.pedidos.model.DTOs.ClienteDTO;
import com.pedidosja.pedidos.model.entity.Cliente;
import com.pedidosja.pedidos.repository.ClienteRepository;
import com.pedidosja.pedidos.services.ClienteService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private  ClienteService clienteService;

    //GET
    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listarCliente() {

        return clienteService.listarCliente();
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> criarCliente(@RequestBody ClienteDTO dto) {
        return clienteService.criarCliente(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> editarCliente(@PathVariable Long id, ClienteDTO dto) {
        return clienteService.editarCliente(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
        clienteService.deletarCliente(id);
        return ResponseEntity.ok().build();
    }
 }
