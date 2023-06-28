package com.fiap.techchallenge.pessoa.controller;


import com.fiap.techchallenge.pessoa.domain.request.EletrodomesticoRequest;
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

}
