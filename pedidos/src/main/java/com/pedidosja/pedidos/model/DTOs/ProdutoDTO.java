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
    private double preco;
    private int quantidade;

    public ProdutoDTO(Produto pedido) {
        this.id = pedido.getId();
        this.nome = pedido.getNome();
        this.descricao = pedido.getDescricao();
        this.preco = pedido.getPreco();
        this.quantidade = pedido.getQuantidade();
    }

    public static Produto toEntity(ProdutoDTO pedidoDTO) {
        Produto pedido = new Produto();
        pedido.setNome(pedidoDTO.getNome());
        pedido.setDescricao(pedidoDTO.getDescricao());
        pedido.setPreco(pedidoDTO.getPreco());
        pedido.setQuantidade(pedidoDTO.getQuantidade());

        return pedido;
    }
}
