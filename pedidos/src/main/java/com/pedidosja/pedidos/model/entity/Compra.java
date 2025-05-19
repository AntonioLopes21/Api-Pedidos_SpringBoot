package com.pedidosja.pedidos.model.entity;

import com.pedidosja.pedidos.model.DTOs.ClienteDTO;
import com.pedidosja.pedidos.model.DTOs.PedidoDTO;
import jakarta.persistence.*;
import jakarta.persistence.ManyToOne;

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
