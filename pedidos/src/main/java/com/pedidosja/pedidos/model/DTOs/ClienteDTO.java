package com.pedidosja.pedidos.model.DTOs;

import com.pedidosja.pedidos.model.entity.Cliente;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class ClienteDTO {

    private String nome;
    private String email;

    public ClienteDTO(Cliente cliente) {
        this.nome = cliente.getNome();
        this.email = cliente.getEmail();
    }

    public static Cliente toEntity (ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setNome(clienteDTO.getNome());
        cliente.setEmail(clienteDTO.getEmail());

        return cliente;
    }

    public static ClienteResponseDTO toDTO (Cliente cliente) {
        ClienteResponseDTO clienteResponseDTO = new ClienteResponseDTO();
        clienteResponseDTO.setNome(cliente.getNome());
        clienteResponseDTO.setEmail(cliente.getEmail());

        return clienteResponseDTO;
    }
}
