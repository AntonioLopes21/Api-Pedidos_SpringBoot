package com.pedidosja.pedidos.repository;

import com.pedidosja.pedidos.model.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, String> {
}
