package com.pedidosja.pedidos.services;

import com.pedidosja.pedidos.model.DTOs.PedidoDTO;
import com.pedidosja.pedidos.model.entity.Cliente;
import com.pedidosja.pedidos.model.entity.Pedido;
import com.pedidosja.pedidos.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoService {
    private final PedidoRepository pedidoRepository;

    //método get - lógica
    public ResponseEntity<PedidoDTO> getPedido(@RequestBody PedidoDTO pedido){
        Pedido pedidoConvertido = PedidoDTO.toEntity(pedido);
        Pedido pedidoSalvo = pedidoRepository.save(pedidoConvertido);

        return ResponseEntity.ok(new PedidoDTO(pedidoSalvo));
    }

}
