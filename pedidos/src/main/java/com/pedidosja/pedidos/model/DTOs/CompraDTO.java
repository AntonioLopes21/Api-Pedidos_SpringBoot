package com.pedidosja.pedidos.model.DTOs;

import com.pedidosja.pedidos.model.entity.Cliente;
import com.pedidosja.pedidos.model.entity.Compra;
import com.pedidosja.pedidos.model.entity.Produto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class CompraDTO {
    private Long id;
    private Long produtoId;
    private Long clienteId;
    private int quantidade;

    public static Compra toEntity (CompraDTO dto) {
        Compra compra = new Compra();
        compra.setId(dto.getId());

        Produto produto = new Produto();
        produto.setId(dto.getProdutoId());
        compra.setProduto(produto);

        Cliente cliente = new Cliente();
        cliente.setId(dto.getClienteId());
        compra.setCliente(cliente);

        compra.setQuantidade(dto.getQuantidade());

        return compra;
    }
}
