package com.pedidosja.pedidos.repository;

import com.pedidosja.pedidos.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Long id(Long id);
}
