package com.pedidosja.pedidos.services;

import com.pedidosja.pedidos.model.DTOs.ProdutoDTO;
import com.pedidosja.pedidos.model.entity.Produto;
import com.pedidosja.pedidos.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    //GET
    public ResponseEntity<List<ProdutoDTO>> listarPedido() {
        List<Produto> produto = produtoRepository.findAll();
        List<ProdutoDTO> dto = produto.stream()
                .map(ProdutoDTO:: new)
                .toList();

        return ResponseEntity.ok(dto);

    }
    //POST
    public ResponseEntity<ProdutoDTO> criarPedido(@RequestBody ProdutoDTO produto){
        Produto pedidoConvertido = ProdutoDTO.toEntity(produto);
        Produto pedidoSalvo = produtoRepository.save(pedidoConvertido);

        return ResponseEntity.ok(new ProdutoDTO(pedidoSalvo));
    }

    //PUT
    public ResponseEntity<ProdutoDTO> editarPedido(@PathVariable String id, @RequestBody ProdutoDTO pedido) {
        if(produtoRepository.existsById(id)) {
            pedido.setNome(pedido.getNome());
            pedido.setDescricao(pedido.getDescricao());

            return ResponseEntity.ok(pedido);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //DELETE
    public ResponseEntity<Void> deletarPedido(@PathVariable String id) {
        if(produtoRepository.existsById(id)) {
            produtoRepository.deleteById(id);
        }
        return ResponseEntity.notFound().build();
    }



}
