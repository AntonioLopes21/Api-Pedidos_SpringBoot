package com.pedidosja.pedidos.services;

import com.pedidosja.pedidos.exceptions.ResourceNotFoundException;
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

    public double calcularValorCompra(Produto produto, Compra compra) {
        return produto.getPreco() * compra.getQuantidade();
    }

    //GET
    public List<Compra> listarCompras() {
        return compraRepository.findAll();
    }

    //POST
    public ResponseEntity<Compra> criarCompra(CompraDTO dto) {
        Cliente cliente = clienteRepository.findById(dto.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        Produto produto = produtoRepository.findById(dto.getProdutoId())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        Compra compraConvertida = CompraDTO.toEntity(dto);
        compraConvertida.setCliente(cliente);
        compraConvertida.setProduto(produto);

        compraConvertida.setQuantidade(dto.getQuantidade());

        compraConvertida.setValorTotalCompra(calcularValorCompra(produto, compraConvertida));


        return ResponseEntity.ok(compraRepository.save(compraConvertida));
    }

    //PUT
    public ResponseEntity<Compra> editarCompra(CompraDTO dto, Long id) {
        Compra compraExistente = compraRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Compra não encontrada"));

        Cliente cliente = clienteRepository.findById(dto.getClienteId())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));
        Produto produto = produtoRepository.findById(dto.getProdutoId())
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado"));

        compraExistente.setCliente(cliente);
        compraExistente.setProduto(produto);

        compraExistente.setQuantidade(dto.getQuantidade());
        compraExistente.setValorTotalCompra(calcularValorCompra(produto, compraExistente));

        return ResponseEntity.ok(compraRepository.save(compraExistente));
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
