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
    public ResponseEntity<List<ClienteDTO>> listarCliente() {
        List<Cliente> cliente = clienteRepository.findAll();
        List<ClienteDTO> dto = cliente.stream()
                .map(ClienteDTO :: new).toList();

        return ResponseEntity.ok(dto);
    }

    //POST
    public ResponseEntity<ClienteDTO> criarCliente(@RequestBody ClienteDTO dto) {
        Cliente clienteConversao = ClienteDTO.toEntity(dto);
        Cliente salvo = clienteRepository.save(clienteConversao);
        return ResponseEntity.ok(new ClienteDTO(salvo));
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
    public ResponseEntity.BodyBuilder deletarCliente(@PathVariable Long id) {
        if(clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
        }
        return ResponseEntity.ok();
    }



}
