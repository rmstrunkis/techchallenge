package com.fiap.techchallenge.pessoa.controller;

import com.fiap.techchallenge.pessoa.config.ValidatorBean;
import com.fiap.techchallenge.pessoa.domain.request.PessoaRequest;
import com.fiap.techchallenge.pessoa.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Path;
import java.util.Map;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
    @Autowired
    PessoaService pessoaService;

    @Autowired
    private ValidatorBean validator;

    @PostMapping
    public ResponseEntity criarNovaPessoa(@RequestBody PessoaRequest pessoaRequest){

        Map<Path, String> validar = validator.validar(pessoaRequest);
        if(!validar.isEmpty()) return ResponseEntity.badRequest().body(validar);

        return pessoaService.criarNovaPessoa(pessoaRequest);
    }
}