package com.pedidosja.pedidos.services;

import com.pedidosja.pedidos.model.entity.Pedido;
import com.pedidosja.pedidos.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoService {
    private final PedidoRepository pedidoRepository;

    //método get - lógica
    public ResponseEntity<List<Pedido>> listarPedido() {
        return ResponseEntity.ok(pedidoRepository.findAll());
    }

    //POST
    public ResponseEntity<Pedido> criarPedido (@RequestBody Pedido pedido) {
        return ResponseEntity.ok(pedidoRepository.save(pedido));
    }

    //PUT -> edição
    public ResponseEntity<Pedido> editarPedido(@PathVariable String id,@RequestBody Pedido pedido) {
        if(pedidoRepository.existsById(id)) {
            pedido.setNome(pedido.getNome());
            pedido.setEmail(pedido.getEmail());

            return ResponseEntity.ok(pedido);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Void> deletarPedido(String id) {
        if(pedidoRepository.existsById(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }

    }

}
