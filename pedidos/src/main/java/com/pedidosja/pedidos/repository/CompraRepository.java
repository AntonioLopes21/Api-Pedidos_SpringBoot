package com.pedidosja.pedidos.repository;

import com.pedidosja.pedidos.model.entity.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompraRepository extends JpaRepository<Compra, Long> {
}
