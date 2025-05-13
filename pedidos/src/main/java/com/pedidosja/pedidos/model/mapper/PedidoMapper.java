package com.pedidosja.pedidos.model.mapper;

import com.pedidosja.pedidos.model.DTOs.PedidoDTO;
import com.pedidosja.pedidos.model.DTOs.PedidoResponseDTO;
import com.pedidosja.pedidos.model.entity.Pedido;

public class PedidoMapper {

    public static Pedido toEntity(PedidoDTO pedidoDTO) {
        Pedido pedido = new Pedido();
        pedido.setNome(pedidoDTO.getNome());
        pedido.setEmail(pedidoDTO.getEmail());

        return pedido;
    }

    public static PedidoResponseDTO toDTO(Pedido pedido) {
        PedidoResponseDTO pedidoDTO = new PedidoResponseDTO();
        pedidoDTO.setNome(pedido.getNome());
        pedidoDTO.setEmail(pedidoDTO.getEmail());

        return pedidoDTO;
    }
}
