package com.exemplo.fornecedorservice.config;

import com.exemplo.fornecedorservice.model.Fornecedor;
import com.exemplo.fornecedorservice.repository.FornecedorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Popula o banco H2 em memoria com fornecedores de teste assim que a aplicacao sobe.
 */
@Component
public class DataInitializer implements CommandLineRunner {

    private final FornecedorRepository fornecedorRepository;

    public DataInitializer(FornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }

    @Override
    public void run(String... args) {
        fornecedorRepository.save(new Fornecedor("Tech Distribuidora", "contato@techdist.com", "00000000"));
        fornecedorRepository.save(new Fornecedor("Logistica Express", "atendimento@logexpress.com", "11111"));
        fornecedorRepository.save(new Fornecedor("Eletronicos Brasil", "vendas@eletronicosbr.com", "222222"));
        fornecedorRepository.save(new Fornecedor("Suprimentos Globais", "suprimentos@globais.com", "333333"));
        fornecedorRepository.save(new Fornecedor("Atacado Central", "contato@atacadocentral.com", "4444444"));
        fornecedorRepository.save(new Fornecedor("Mega Componentes", "vendas@megacomponentes.com", "555555"));
        fornecedorRepository.save(new Fornecedor("Alfa Importacoes", "alfa@importacoes.com", "66666"));
        fornecedorRepository.save(new Fornecedor("Beta Solucoes", "beta@solucoes.com", "7777777"));
        fornecedorRepository.save(new Fornecedor("Gama Distribuicao", "gama@distribuicao.com", "8888888"));
        fornecedorRepository.save(new Fornecedor("Delta Fabricacao", "delta@fabricacao.com", "99999999"));
    }
}
