package com.pedidosja.pedidos.services;

import com.pedidosja.pedidos.model.DTOs.CompraDTO;
import com.pedidosja.pedidos.model.entity.Cliente;
import com.pedidosja.pedidos.model.entity.Compra;
import com.pedidosja.pedidos.model.entity.Produto;
import com.pedidosja.pedidos.repository.ClienteRepository;
import com.pedidosja.pedidos.repository.CompraRepository;
import com.pedidosja.pedidos.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompraService {
    private final CompraRepository compraRepository;

    private final ClienteRepository clienteRepository;

    private final ProdutoRepository produtoRepository;

    //GET
    public List<Compra> listarCompras() {
        return compraRepository.findAll();
    }

    //POST
    public ResponseEntity<Compra> criarCompra(CompraDTO compraDTO) {
        Compra compraConvertida = CompraDTO.toEntity(compraDTO);

        return ResponseEntity.ok(compraRepository.save(compraConvertida));
    }

    //PUT
    public ResponseEntity<Compra> editarCompra(CompraDTO dto, Long id) {
            Compra convertida = CompraDTO.toEntity(dto);

            if(compraRepository.existsById(id)) {
                convertida.setId(id);
                convertida.setProduto(dto.getProduto());
                convertida.setCliente(dto.getCliente());
                compraRepository.save(convertida);

                return ResponseEntity.status(HttpStatus.OK).body(convertida);
            } else {
                return ResponseEntity.notFound().build();
            }
    }

    //DELETE
    public ResponseEntity<Void> excluirCompra(Long id) {
        if(compraRepository.existsById(id)) {
            compraRepository.deleteById(id);

            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        } else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
