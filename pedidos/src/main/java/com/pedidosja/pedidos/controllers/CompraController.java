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
    private final CompraRepository compraRepository;

    @GetMapping
    public ResponseEntity<List<Compra>> listarCompras() {
        return ResponseEntity.ok(compraService.listarCompras());
    }

    @PostMapping
    public ResponseEntity<Compra> criarCompra(@RequestBody CompraDTO dto) {
        return ResponseEntity.ok(compraService.criarCompra(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Compra> editarCompra(@PathVariable Long id,@RequestBody Compra compra) {
        if(compraRepository.existsById(id)) {
            return compraService.editarCompra(compra, id);
        } else
            return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirCompra(@PathVariable Long id) {
        if(compraRepository.existsById(id)) {
             compraService.excluirCompra(id);
             return ResponseEntity.status(HttpStatus.ACCEPTED).body("Compra deletada com sucesso!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
