package com.pedidosja.pedidos.services;

import com.pedidosja.pedidos.model.DTOs.ProdutoDTO;
import com.pedidosja.pedidos.model.entity.Produto;
import com.pedidosja.pedidos.repository.ProdutoRepository;
import jakarta.persistence.Table;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
        return ResponseEntity.status(HttpStatus.OK).body(produtoRepository.findAll());
    }
    //POST
    public ResponseEntity<ProdutoDTO> criarPedido(@RequestBody ProdutoDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(dto));
    }

    //PUT
    public ResponseEntity<ProdutoDTO> editarPedido(@PathVariable Long id, @RequestBody ProdutoDTO dto) {

        if(produtoRepository.existsById(id)) {
            ProdutoDTO recebedor = new ProdutoDTO();

            recebedor.setId(id);
            recebedor.setNome(dto.getNome());
            recebedor.setDescricao(dto.getDescricao());

            return ResponseEntity.ok(recebedor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //DELETE
    public ResponseEntity<Void> deletarPedido(@PathVariable Long id) {
        if(produtoRepository.existsById(id)) {
            produtoRepository.deleteById(id);
        }
        return ResponseEntity.notFound().build();
    }



}
