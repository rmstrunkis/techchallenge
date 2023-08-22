package com.fiap.techchallenge.pessoa.controller;

import com.fiap.techchallenge.pessoa.config.ValidatorBean;
import com.fiap.techchallenge.pessoa.domain.Pessoa;
import com.fiap.techchallenge.pessoa.domain.PessoaDependente;
import com.fiap.techchallenge.pessoa.domain.PessoaTitular;
import com.fiap.techchallenge.pessoa.domain.request.PessoaRequest;
import com.fiap.techchallenge.pessoa.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Path;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
    @Autowired
    PessoaService pessoaService;

    @GetMapping
    public List<Pessoa> getAll() {
        return pessoaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> getById(@PathVariable Long id) {
        Optional<Pessoa> pessoa = pessoaService.findById(id);
        if (pessoa.isPresent()) {
            return ResponseEntity.ok(pessoa.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Pessoa create(@RequestBody Pessoa pessoa) {
        return pessoaService.save(pessoa);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> update(@PathVariable Long id, @RequestBody Pessoa pessoa) {
        Optional<Pessoa> existingPessoa = pessoaService.findById(id);
        if (existingPessoa.isPresent()) {
            Pessoa updatedPessoa = existingPessoa.get();
            updatedPessoa.setCpf(pessoa.getCpf());
            updatedPessoa.setNome(pessoa.getNome());
            updatedPessoa.setTelefone(pessoa.getTelefone());
            updatedPessoa.setEmail(pessoa.getEmail());
            updatedPessoa.setSenha(pessoa.getSenha());
            if (updatedPessoa instanceof PessoaDependente) {
                ((PessoaDependente) updatedPessoa).setTitular(((PessoaDependente) pessoa).getTitular());
            } else if (updatedPessoa instanceof PessoaTitular) {
                ((PessoaTitular) updatedPessoa).setDependentes(((PessoaTitular) pessoa).getDependentes());
            }
            pessoaService.save(updatedPessoa);
            return ResponseEntity.ok(updatedPessoa);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<Pessoa> existingPessoa = pessoaService.findById(id);
        if (existingPessoa.isPresent()) {
            pessoaService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }