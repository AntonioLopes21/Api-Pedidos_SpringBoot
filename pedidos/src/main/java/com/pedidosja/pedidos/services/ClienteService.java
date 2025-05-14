package com.pedidosja.pedidos.services;

import com.pedidosja.pedidos.model.DTOs.ClienteDTO;
import com.pedidosja.pedidos.model.DTOs.ClienteResponseDTO;
import com.pedidosja.pedidos.model.entity.Cliente;
import com.pedidosja.pedidos.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ResponseEntity<ClienteDTO> criarCliente(@RequestBody ClienteDTO dto) {
        Cliente clienteConversao = ClienteDTO.toEntity(dto);
        Cliente salvo = clienteRepository.save(clienteConversao);
        return ResponseEntity.ok(new ClienteDTO(salvo));
    }



}
