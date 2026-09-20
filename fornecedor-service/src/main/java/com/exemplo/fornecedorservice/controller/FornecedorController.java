package com.exemplo.fornecedorservice.controller;

import com.exemplo.fornecedorservice.dto.FornecedorDTO;
import com.exemplo.fornecedorservice.model.Fornecedor;
import com.exemplo.fornecedorservice.service.FornecedorService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

    private final FornecedorService service;

    public FornecedorController(FornecedorService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Object> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarPorId(@PathVariable Long id) {
        var resultado = service.buscarPorId(id);
        if (resultado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(resultado);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Object> cadastrar(@RequestBody FornecedorDTO fornecedorDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.cadastrar(fornecedorDTO));
    }

    @GetMapping("/produtos")
    public ResponseEntity<Object> listarProdutos() {
        return ResponseEntity.ok(service.listarProdutos());
    }

}
