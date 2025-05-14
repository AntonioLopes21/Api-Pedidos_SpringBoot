package com.pedidosja.pedidos.model.DTOs;

import com.pedidosja.pedidos.model.entity.Produto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@RequiredArgsConstructor
@Getter
@Setter
public class ProdutoDTO {
    private Long id;
    private String nome;
    private String descricao;

    public ProdutoDTO(Produto pedido) {
        this.id = pedido.getId();
        this.nome = pedido.getNome();
        this.descricao = pedido.getDescricao();
    }

    public static Produto toEntity(ProdutoDTO pedidoDTO) {
        Produto pedido = new Produto();
        pedido.setNome(pedidoDTO.getNome());
        pedido.setDescricao(pedidoDTO.getDescricao());

        return pedido;
    }

    public static PedidoResponseDTO toDTO(Produto pedido) {
        PedidoResponseDTO pedidoDTO = new PedidoResponseDTO();
        pedidoDTO.setNome(pedido.getNome());
        pedidoDTO.setEmail(pedidoDTO.getEmail());

        return pedidoDTO;
    }
}
