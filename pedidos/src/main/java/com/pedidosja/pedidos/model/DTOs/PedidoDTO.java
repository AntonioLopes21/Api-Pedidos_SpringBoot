package com.pedidosja.pedidos.model.DTOs;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class PedidoDTO {
    private String nome;
    private String email;
}
