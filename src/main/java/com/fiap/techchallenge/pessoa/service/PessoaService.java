package com.fiap.techchallenge.pessoa.service;

import com.fiap.techchallenge.pessoa.domain.PessoaDependente;
import com.fiap.techchallenge.pessoa.domain.PessoaTitular;
import com.fiap.techchallenge.pessoa.domain.request.PessoaRequest;
import com.fiap.techchallenge.pessoa.domain.Pessoa;
import com.fiap.techchallenge.pessoa.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class PessoaService {
    @Autowired
    PessoaRepository pessoaRepository;
    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    public Optional<Pessoa> findById(Long id) {
        return pessoaRepository.findById(id);
    }

    public Pessoa save(Pessoa pessoa) {
        if (pessoa instanceof PessoaDependente) {
            // lógica para lidar com um objeto PessoaDependente
        } else if (pessoa instanceof PessoaTitular) {
            // lógica para lidar com um objeto PessoaTitular
        }
        return pessoaRepository.save(pessoa);
    }

    public void deleteById(Long id) {
        pessoaRepository.deleteById(id);
    }
}