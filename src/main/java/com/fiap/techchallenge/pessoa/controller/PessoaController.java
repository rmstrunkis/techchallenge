package com.fiap.techchallenge.pessoa.controller;

import com.fiap.techchallenge.pessoa.dto.PessoaDTO;
import com.fiap.techchallenge.pessoa.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Path;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
    @Autowired
    PessoaService pessoaService;
    @PostMapping
    public ResponseEntity criarNovaPessoa(@RequestBody PessoaDTO pessoaDTO){


        Map<Path, String> validar = pessoaService.validar(pessoaDTO);
        if(!validar.isEmpty()) return ResponseEntity.badRequest().body(validar);

        return pessoaService.criarNovaPessoa(pessoaDTO);
    }
}