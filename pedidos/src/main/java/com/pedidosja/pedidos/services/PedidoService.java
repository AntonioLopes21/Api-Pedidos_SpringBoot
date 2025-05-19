package com.pedidosja.pedidos.services;

import com.pedidosja.pedidos.model.DTOs.PedidoDTO;
import com.pedidosja.pedidos.model.entity.Cliente;
import com.pedidosja.pedidos.model.entity.Pedido;
import com.pedidosja.pedidos.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PedidoService {
    private final PedidoRepository pedidoRepository;

    //GET
    public ResponseEntity<List<PedidoDTO>> listarPedido(){
        return ResponseEntity.status(HttpStatus.OK).body(pedidoRepository.findAll());
    }

    //POST
    public ResponseEntity<PedidoDTO> criarPedido(@RequestBody PedidoDTO dto) {
        dto.setNome(dto.getNome());
        dto.setDescricao(dto.getDescricao());

        pedidoRepository.save(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    //PUT
    public ResponseEntity<PedidoDTO> editarPedido(Long id, PedidoDTO dto) {
        Optional<PedidoDTO> optionalPedido = pedidoRepository.findById(id);

        PedidoDTO pedidoDTO = null;
        if (optionalPedido.isPresent()) {
            pedidoDTO = optionalPedido.get();

            pedidoDTO.setId(id);
            pedidoDTO.setNome(dto.getNome());
            pedidoDTO.setDescricao(dto.getDescricao());

            pedidoRepository.save(pedidoDTO);
        }
        return ResponseEntity.status(HttpStatus.OK).body(pedidoDTO);
    }

    //DELETE
    public ResponseEntity<Void> deletarPedido(Long id) {
        Optional<PedidoDTO> optPedido = pedidoRepository.findById(id);
        if(optPedido.isPresent()) {
            pedidoRepository.deleteById(id);
        }

        return ResponseEntity.ok().build();
    }

}
