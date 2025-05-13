package com.pedidosja.pedidos.model.DTOs;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ClienteResponseDTO {
    private String id;
    private String nome;
    private String email;
}
