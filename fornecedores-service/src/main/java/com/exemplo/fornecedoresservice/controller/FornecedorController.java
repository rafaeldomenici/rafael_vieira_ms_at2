package com.exemplo.fornecedoresservice.controller;


import com.exemplo.fornecedoresservice.dto.ProdutoDTO;
import com.exemplo.fornecedoresservice.model.Fornecedor;
import com.exemplo.fornecedoresservice.repository.FornecedorRepository;
import com.exemplo.fornecedoresservice.service.FornecedorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

    private final FornecedorService fornecedorService;

    public FornecedorController(FornecedorService fornecedorService) {
        this.fornecedorService = fornecedorService;
    }

    @GetMapping
    public List<Fornecedor> listarTodos() {
        return fornecedorService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> buscarPorId(@PathVariable Long id) {
        return fornecedorService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Object> cadastrarFornecedor(@RequestBody Fornecedor fornecedor) {
        Fornecedor fornecedorCadastrado = fornecedorService.cadastrarFornecedor(fornecedor);
        return ResponseEntity.status(201).body(fornecedorCadastrado);
    }

    @GetMapping("/produtos")
    public List<ProdutoDTO> obterTodosProdutos() {
        return fornecedorService.obterProdutos();
    }
}
