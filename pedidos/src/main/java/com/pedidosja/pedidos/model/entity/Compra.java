package com.pedidosja.pedidos.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_produto_cliente")
@Getter
@Setter
@RequiredArgsConstructor
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produtoId;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente clienteId;

}
