package com.pedidosja.pedidos.controllers;

import com.pedidosja.pedidos.model.entity.Pedido;
import com.pedidosja.pedidos.services.PedidoService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<Pedido>> listarPedido() {
        return pedidoService.listarPedido();
    }

    @PostMapping
    public ResponseEntity<Pedido> criarPedido(@RequestBody Pedido pedido) {
        return pedidoService.criarPedido(pedido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> editarPedido(@PathVariable String id, Pedido pedido) {
        return pedidoService.editarPedido(id, pedido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPedido(@PathVariable String id) {
        return pedidoService.deletarPedido(id);
    }
}
