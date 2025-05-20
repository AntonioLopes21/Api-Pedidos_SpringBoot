package com.pedidosja.pedidos.services;

import com.pedidosja.pedidos.model.DTOs.ClienteDTO;
import com.pedidosja.pedidos.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    //GET
    public ResponseEntity<List<ClienteDTO>> listarCliente() {
        return ResponseEntity.status(HttpStatus.OK).body(clienteRepository.findAll());
    }

    //POST
    public ResponseEntity<ClienteDTO> criarCliente(@RequestBody ClienteDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteRepository.save(dto));
    }

    //PUT
    public ResponseEntity<ClienteDTO> editarCliente(@PathVariable Long id, @RequestBody ClienteDTO dto) {
        if(clienteRepository.existsById(id)) {
            ClienteDTO novoCliente = new ClienteDTO();
            novoCliente.setId(id);
            novoCliente.setNome(dto.getNome());
            novoCliente.setEmail(dto.getEmail());

            return ResponseEntity.ok(novoCliente);
        } else {
            return ResponseEntity.notFound().build();
        }


    }

    //DELETE
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
        if(clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
        }
        return ResponseEntity.ok().build();
    }



}
