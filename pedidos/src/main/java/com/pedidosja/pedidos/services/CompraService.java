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
    public Compra criarCompra(CompraDTO compraDTO) {
        Produto produto = produtoRepository.findById(compraDTO.getProdutoId()).orElseThrow(() -> new RuntimeException("Produto não encontrado."));

        Cliente cliente = clienteRepository.findById(compraDTO.getClienteId()).orElseThrow(() -> new RuntimeException("Cliente não encontrado."));

        Compra compra = new Compra();
        compra.setCliente(cliente);
        compra.setProduto(produto);

        return compraRepository.save(compra);
    }

    //PUT
    public ResponseEntity<Compra> editarCompra(Compra compra, Long id) {
        if(compraRepository.existsById(id)) {

            compra.setId(id);
            compra.setCliente(compra.getCliente());
            compra.setProduto(compra.getProduto());

            compraRepository.save(compra);
            return ResponseEntity.ok(compra);
        } else
            return ResponseEntity.notFound().build();
    }

    public ResponseEntity<String> excluirCompra(Long id) {
        if(compraRepository.existsById(id)) {
            compraRepository.deleteById(id);

            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Compra com id:" + id + " deletada com sucesso!");
        } else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Compra com id:" + id + " não encontrada.");
    }

}
