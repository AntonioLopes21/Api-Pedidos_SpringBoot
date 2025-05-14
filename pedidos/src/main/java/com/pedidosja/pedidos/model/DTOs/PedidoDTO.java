package com.pedidosja.pedidos.model.DTOs;

import com.pedidosja.pedidos.model.entity.Pedido;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@RequiredArgsConstructor
@Getter
@Setter
public class PedidoDTO {
    private String nome;
    private String descricao;

    public PedidoDTO (Pedido pedido) {
        this.nome = pedido.getNome();
        this.descricao = pedido.getDescricao();
    }

    public static Pedido toEntity(PedidoDTO pedidoDTO) {
        Pedido pedido = new Pedido();
        pedido.setNome(pedidoDTO.getNome());
        pedido.setDescricao(pedidoDTO.getDescricao());

        return pedido;
    }

    public static PedidoResponseDTO toDTO(Pedido pedido) {
        PedidoResponseDTO pedidoDTO = new PedidoResponseDTO();
        pedidoDTO.setNome(pedido.getNome());
        pedidoDTO.setEmail(pedidoDTO.getEmail());

        return pedidoDTO;
    }
}
