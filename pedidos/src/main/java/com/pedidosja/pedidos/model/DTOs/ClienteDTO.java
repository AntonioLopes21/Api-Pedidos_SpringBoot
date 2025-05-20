package com.pedidosja.pedidos.model.DTOs;

import com.pedidosja.pedidos.model.entity.Cliente;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
public class ClienteDTO {

    private Long id;
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

}
