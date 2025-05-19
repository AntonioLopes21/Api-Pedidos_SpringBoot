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
    public ResponseEntity<CompraDTO> criarCompra(@RequestBody CompraDTO compraDTO) {
        Compra compra = CompraDTO.toEntity(compraDTO);
        Compra dto = compraRepository.save(compra);

        return ResponseEntity.ok(new CompraDTO(dto));
    }

    //PUT
    public ResponseEntity<Compra> editarCompra(Compra compra, Long id) {

             compraRepository.findById(id).map(compraExistente -> {
                compraExistente.setId(id);
                compraExistente.setCliente(compra.getCliente());
                compraExistente.setProduto(compra.getProduto());
                compraRepository.save(compraExistente);

                return ResponseEntity.ok(compraExistente);
            }).orElse(ResponseEntity.notFound().build());

             return ResponseEntity.status(HttpStatus.OK).body(compra);

    }

    //DELETE
    public ResponseEntity<String> excluirCompra(Long id) {
        if(compraRepository.existsById(id)) {
            compraRepository.deleteById(id);

            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Compra com id:" + id + " deletada com sucesso!");
        } else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Compra com id:" + id + " não encontrada.");
    }

}
