package com.exemplo.fornecedorservice.service;

import com.exemplo.fornecedorservice.dto.FornecedorDTO;
import com.exemplo.fornecedorservice.dto.ProdutoDTO;
import com.exemplo.fornecedorservice.interfaces.ProdutoClient;
import com.exemplo.fornecedorservice.model.Fornecedor;
import com.exemplo.fornecedorservice.repository.FornecedorRepository;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

/**
 * Regra de negocio de Fornecedor. O controller nao fala direto com o repository,
 * fala com este service.
 */
@Service
public class FornecedorService {

    private final FornecedorRepository fornecedorRepository;
    private final ProdutoClient produtoClient;

    public FornecedorService(FornecedorRepository fornecedorRepository, ProdutoClient produtoClient) {
        this.fornecedorRepository = fornecedorRepository;
        this.produtoClient = produtoClient;
    }

    public List<Fornecedor> listarTodos() {
        return fornecedorRepository.findAll();
    }

    public Fornecedor buscarPorId(Long id) {
        return fornecedorRepository.findById(id)
                .orElse(null);
    }

    public Fornecedor cadastrar(FornecedorDTO fornecedorDTO) {
        Fornecedor fornecedor = new Fornecedor(
                fornecedorDTO.getNome(),
                fornecedorDTO.getEmail(),
                fornecedorDTO.getCnpj()
        );

        return fornecedorRepository.save(fornecedor);
    }

    public List<ProdutoDTO> listarProdutos() {
        List<ProdutoDTO> produtos = produtoClient.listarProdutos();
        return produtos;
    }
}
