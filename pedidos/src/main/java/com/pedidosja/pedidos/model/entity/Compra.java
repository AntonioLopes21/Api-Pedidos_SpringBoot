package com.pedidosja.pedidos.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_pedido_cliente")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Pedido pedido;

    @ManyToOne
    private Cliente cliente;

}
