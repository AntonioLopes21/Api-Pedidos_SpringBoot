package com.pedidosja.pedidos.repository;

import com.pedidosja.pedidos.model.DTOs.ClienteDTO;
import com.pedidosja.pedidos.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
