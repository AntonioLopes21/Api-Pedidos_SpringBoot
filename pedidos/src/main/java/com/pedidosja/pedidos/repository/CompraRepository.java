package com.pedidosja.pedidos.repository;

import com.pedidosja.pedidos.model.DTOs.CompraDTO;
import com.pedidosja.pedidos.model.entity.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {
}
