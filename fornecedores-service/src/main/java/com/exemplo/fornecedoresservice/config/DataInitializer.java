package com.exemplo.fornecedoresservice.config;

import com.exemplo.fornecedoresservice.model.Fornecedor;
import com.exemplo.fornecedoresservice.repository.FornecedorRepository;
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
        fornecedorRepository.save(new Fornecedor("Ana Souza", "1234567891"));
        fornecedorRepository.save(new Fornecedor("Bruno Lima", "1234567892"));
        fornecedorRepository.save(new Fornecedor("Carla Mendes", "1234567893"));
        fornecedorRepository.save(new Fornecedor("Diego Rocha", "1234567894"));
        fornecedorRepository.save(new Fornecedor("Elisa Prado", "1234567895"));

    }
}
