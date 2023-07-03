package com.fiap.techchallenge.pessoa.controller;

import com.fiap.techchallenge.pessoa.domain.request.EnderecoRequest;
import com.fiap.techchallenge.pessoa.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    EnderecoService enderecoService;

    @PostMapping("/cadastrar")
    public ResponseEntity cadastrarEndereco(@RequestBody EnderecoRequest enderecoRequest) {

        return enderecoService.cadastrarEndereco(enderecoRequest);
    }

}
