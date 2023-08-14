package com.fiap.techchallenge.pessoa.controller;


import com.fiap.techchallenge.pessoa.domain.request.PessoaRequest;
import com.fiap.techchallenge.pessoa.domain.response.dto.PessoaResponseDto;
import com.fiap.techchallenge.pessoa.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/pessoas")
public class PessoaController {
    @Autowired
    PessoaService pessoaService;

    @PostMapping("/cadastrar")
    public ResponseEntity cadastrarPessoa(@RequestBody PessoaRequest pessoaRequest){

        return pessoaService.cadastrarPessoa(pessoaRequest);
    }

    @GetMapping("/consultar")
    public ResponseEntity consultarPessoa(@RequestParam Long id){

        return ResponseEntity.ok(pessoaService.consultarPessoa(id));
    }

    @PutMapping("/atualizar")
    public ResponseEntity<PessoaResponseDto> atualizarPessoa(@RequestBody PessoaRequest pessoaRequest, @RequestParam Long id){
        return pessoaService.atualizarPessoa(pessoaRequest, id);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<PessoaResponseDto> deletePessoa(@RequestParam Long id){
        return pessoaService.deletarPessoa(id);
    }
}