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
}
