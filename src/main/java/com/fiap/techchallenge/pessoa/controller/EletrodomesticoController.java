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

    @GetMapping("/pesquisar")
    public ResponseEntity pesquisarEletrodomestico(@RequestParam(required = false) String nome, @RequestParam(required = false) String modelo, @RequestParam(required = false) String potencia, @RequestParam(required = false) String serialNumber){

        if((nome == null || nome.isBlank())
                && (modelo == null || modelo.isBlank())
                && (potencia == null || potencia.isBlank())
                && (serialNumber == null || serialNumber.isBlank())){
            return ResponseEntity.badRequest().body("Preencha pelo menos um dos filtos!");
        }

        return eletrodomesticoService.pesquisarEletrodomestico(nome, modelo, potencia, serialNumber);
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
