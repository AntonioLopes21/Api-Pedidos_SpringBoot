package com.pedidosja.pedidos.controllers;

import com.pedidosja.pedidos.model.DTOs.ProdutoDTO;
import com.pedidosja.pedidos.services.ProdutoService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> listarPedido() {
        return produtoService.listarPedido();
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> criarPedido(@RequestBody ProdutoDTO dto) {
        return produtoService.criarPedido(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDTO> editarPedido(@PathVariable Long id,@RequestBody ProdutoDTO dto) {
        return produtoService.editarPedido(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPedido(@PathVariable Long id) {
        return produtoService.deletarPedido(id);
    }
}
