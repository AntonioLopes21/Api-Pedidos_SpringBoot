package com.pedidosja.pedidos.services;

import com.pedidosja.pedidos.model.DTOs.ProdutoDTO;
import com.pedidosja.pedidos.model.entity.Produto;
import com.pedidosja.pedidos.repository.ProdutoRepository;
import jakarta.persistence.Table;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
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
    public ResponseEntity<List<Produto>> listarProduto() {
        return ResponseEntity.status(HttpStatus.OK).body(produtoRepository.findAll());
    }
    //POST
    public ResponseEntity<Produto> criarProduto(@RequestBody ProdutoDTO dto){
        Produto convertido = ProdutoDTO.toEntity(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(convertido));
    }

    //PUT
    public ResponseEntity<Produto> editarProduto(@PathVariable Long id, @RequestBody ProdutoDTO dto) {
        Produto convertido = ProdutoDTO.toEntity(dto);

        if(produtoRepository.existsById(id)) {

            convertido.setId(id);
            convertido.setNome(dto.getNome());
            convertido.setDescricao(dto.getDescricao());
            convertido.setPreco(dto.getPreco());
            convertido.setQuantidade(dto.getQuantidade());
            produtoRepository.save(convertido);

            return ResponseEntity.ok(convertido);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //DELETE
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {

        if(produtoRepository.existsById(id)) {
            produtoRepository.deleteById(id);

            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
