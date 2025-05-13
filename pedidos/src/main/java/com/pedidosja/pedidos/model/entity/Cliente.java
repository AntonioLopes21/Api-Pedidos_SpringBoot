package com.pedidosja.pedidos.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "tb_cliente")
@Getter
@Setter
@RequiredArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String nome;
    private String email;

    @ManyToMany
    @JoinColumn(name = "tb_pedidos"
    )
    private List<Pedido> pedidos;
}
