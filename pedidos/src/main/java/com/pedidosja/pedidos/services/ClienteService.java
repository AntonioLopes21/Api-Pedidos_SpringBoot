package com.pedidosja.pedidos.services;

import com.pedidosja.pedidos.model.DTOs.ClienteDTO;
import com.pedidosja.pedidos.model.entity.Cliente;
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
    public ResponseEntity<List<Cliente>> listarCliente() {

        return ResponseEntity.status(HttpStatus.OK).body(clienteRepository.findAll());
    }

    //POST
    public ResponseEntity<Cliente> criarCliente(@RequestBody ClienteDTO dto) {
        Cliente novoConvertido = ClienteDTO.toEntity(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(clienteRepository.save(novoConvertido));
    }

        //PUT
        public ResponseEntity<Cliente> editarCliente(Long id, ClienteDTO dto) {
            if(clienteRepository.existsById(id)) {
                Cliente novoCliente = ClienteDTO.toEntity(dto);

                novoCliente.setId(id);
                novoCliente.setNome(dto.getNome());
                novoCliente.setEmail(dto.getEmail());
                clienteRepository.save(novoCliente);
                return ResponseEntity.ok(novoCliente);
            } else {
                return ResponseEntity.notFound().build();
            }
        }

    //DELETE
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
        if(clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);

            return ResponseEntity.ok().build();

        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
