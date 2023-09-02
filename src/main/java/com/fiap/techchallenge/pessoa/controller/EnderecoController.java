package com.fiap.techchallenge.pessoa.controller;

import com.fiap.techchallenge.pessoa.domain.request.EnderecoRequest;
import com.fiap.techchallenge.pessoa.domain.response.dto.EnderecoResponseDto;
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

    @GetMapping("/consultar")
    public ResponseEntity consultarEndereco(@RequestParam Long id) {
        return enderecoService.consultarEndereco(id);
    }

    @PutMapping("/atualizar")
    public ResponseEntity<EnderecoResponseDto> atualizarEndereco(@RequestBody EnderecoRequest enderecoRequest, @RequestParam Long id) {
        return enderecoService.atualizarEndereco(enderecoRequest, id);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<EnderecoResponseDto> deletarEndereco(@RequestParam Long id) {
        return enderecoService.deletarEndereco(id);
    }

}
