package com.pedidosja.pedidos.controllers;

import com.pedidosja.pedidos.model.DTOs.ClienteDTO;
import com.pedidosja.pedidos.services.ClienteService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/clientes")
@RestController
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    //GET
    public ResponseEntity<List<ClienteDTO>> listarCliente() {

        return clienteService.listarCliente();
    }
 }
