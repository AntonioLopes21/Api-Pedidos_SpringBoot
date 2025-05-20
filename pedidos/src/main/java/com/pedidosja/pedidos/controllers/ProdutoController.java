package com.pedidosja.pedidos.controllers;

import com.pedidosja.pedidos.model.DTOs.ProdutoDTO;
import com.pedidosja.pedidos.model.entity.Produto;
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
    public ResponseEntity<List<Produto>> listarPedido() {
        return produtoService.listarProduto();
    }

    @PostMapping
    public ResponseEntity<Produto> criarPedido(@RequestBody ProdutoDTO dto) {
        return produtoService.criarProduto(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> editarPedido(@PathVariable Long id,@RequestBody ProdutoDTO dto) {
        return produtoService.editarProduto(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPedido(@PathVariable Long id) {
        return produtoService.deletarProduto(id);
    }
}
