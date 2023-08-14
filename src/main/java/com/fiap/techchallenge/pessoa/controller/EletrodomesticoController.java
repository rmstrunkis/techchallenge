package com.fiap.techchallenge.pessoa.controller;


import com.fiap.techchallenge.pessoa.domain.request.EletrodomesticoRequest;
import com.fiap.techchallenge.pessoa.domain.request.EnderecoRequest;
import com.fiap.techchallenge.pessoa.domain.response.dto.EletrodomesticoResponseDto;
import com.fiap.techchallenge.pessoa.domain.response.dto.EnderecoResponseDto;
import com.fiap.techchallenge.pessoa.service.EletrodomesticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/eletrodomestico")
public class EletrodomesticoController {

    @Autowired
    EletrodomesticoService eletrodomesticoService;

    @PostMapping("/cadastrar")
    public ResponseEntity cadastrarEletrodomestico(@RequestBody EletrodomesticoRequest eletrodomesticoRequest) {

        return eletrodomesticoService.cadastrarEletrodomestico(eletrodomesticoRequest);
    }

    @GetMapping("/consultar")
    public ResponseEntity consultarEletrodomestico(@RequestParam Long id) {
        return eletrodomesticoService.consultarEletrodomestico(id);
    }

    @PutMapping("/atualizar")
    public ResponseEntity<EletrodomesticoResponseDto> atualizarEletrodomestico(@RequestBody EletrodomesticoRequest eletrodomesticoRequest, @RequestParam Long id) {
        return eletrodomesticoService.atualizarEletrodomestico(eletrodomesticoRequest, id);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<EletrodomesticoResponseDto> deletarEletrodomestico(@RequestParam Long id) {
        return eletrodomesticoService.deletarEletrodomestico(id);
    }

}
