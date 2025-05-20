package com.pedidosja.pedidos.controllers;

import com.pedidosja.pedidos.model.DTOs.CompraDTO;
import com.pedidosja.pedidos.model.entity.Compra;
import com.pedidosja.pedidos.repository.CompraRepository;
import com.pedidosja.pedidos.services.CompraService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/compras")
public class CompraController {

    private final CompraService compraService;

    @GetMapping
    public ResponseEntity<List<Compra>> listarCompras() {
        return ResponseEntity.ok(compraService.listarCompras());
    }

    @PostMapping
    public ResponseEntity<Compra> criarCompra(@RequestBody CompraDTO dto) {
        return compraService.criarCompra(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Compra> editarCompra(@PathVariable Long id,@RequestBody CompraDTO compra) {
        return compraService.editarCompra(compra, id);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirCompra(@PathVariable Long id) {
        return compraService.excluirCompra(id);
    }
}
