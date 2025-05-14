package com.pedidosja.pedidos.repository;

import com.pedidosja.pedidos.model.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
