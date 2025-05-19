package com.pedidosja.pedidos.controllers;

import com.pedidosja.pedidos.model.DTOs.PedidoDTO;
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
    public ResponseEntity<List<PedidoDTO>> listarPedido() {
        return pedidoService.listarPedido();
    }

    @PostMapping
    public ResponseEntity<PedidoDTO> criarPedido(@RequestBody PedidoDTO dto) {
        return pedidoService.criarPedido(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoDTO> editarPedido(@PathVariable Long id, PedidoDTO pedido) {
        return pedidoService.editarPedido(id, pedido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPedido(@PathVariable Long id) {
        return pedidoService.deletarPedido(id);
    }
}
