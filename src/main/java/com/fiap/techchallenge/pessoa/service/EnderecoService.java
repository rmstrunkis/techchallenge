package com.fiap.techchallenge.pessoa.service;

import com.fiap.techchallenge.pessoa.config.ValidatorBean;
import com.fiap.techchallenge.pessoa.domain.Endereco;
import com.fiap.techchallenge.pessoa.domain.request.EnderecoRequest;
import com.fiap.techchallenge.pessoa.domain.response.dto.EnderecoResponseDto;
import com.fiap.techchallenge.pessoa.repository.EnderecoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnderecoService {

    private static final String BAD_REQUEST_VAZIO = "As informacoes do resquest sao nulas ou o cadastro ja existe.";

    private static Logger logger = LoggerFactory.getLogger(EnderecoService.class);

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ValidatorBean validator;

    public ResponseEntity cadastrarEndereco (EnderecoRequest enderecoRequest){

        final var validar = validator.validar(enderecoRequest);
        final var enderecoEncontrado = enderecoRepository.findByRuaAndNumero(enderecoRequest.getRua(), enderecoRequest.getNumero());

        if (enderecoEncontrado.isEmpty() && validar.isEmpty()){

            Endereco endereco = new Endereco();
            endereco.setRua(enderecoRequest.getRua());
            endereco.setNumero(enderecoRequest.getNumero());
            endereco.setCep(enderecoRequest.getCep());
            endereco.setBairro(enderecoRequest.getBairro());
            endereco.setCidade(enderecoRequest.getCidade());
            endereco.setEstado(enderecoRequest.getEstado());

            Endereco enderecoSalvo = enderecoRepository.save(endereco);

            logger.info("Endereco cadastrado com sucesso.");
            return ResponseEntity.status(HttpStatus.CREATED).body(new EnderecoResponseDto(enderecoSalvo));
        } else {
            logger.info(BAD_REQUEST_VAZIO);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(BAD_REQUEST_VAZIO + validar.toString());
        }

    }

    public ResponseEntity<List<EnderecoResponseDto>> consultarEndereco (Long id) {

        final var enderecoEncontrado = enderecoRepository.findById(id);

        if (!enderecoEncontrado.isEmpty()) {

            List<EnderecoResponseDto> listaEndereco = enderecoEncontrado.stream().map(EnderecoResponseDto::new).collect(Collectors.toList());

            return ResponseEntity.ok(listaEndereco);
        }
            return ResponseEntity.noContent().build();
    }

    public ResponseEntity<EnderecoResponseDto> atualizarEndereco(EnderecoRequest enderecoRequest, Long id) {

        if (!ObjectUtils.isEmpty(id)) {

            final var enderecoEncontrado = enderecoRepository.findById(id);

            if (!enderecoEncontrado.isEmpty()) {

                enderecoEncontrado.get().setRua(enderecoRequest.getRua());
                enderecoEncontrado.get().setNumero(enderecoRequest.getNumero());
                enderecoEncontrado.get().setCidade(enderecoRequest.getCidade());
                enderecoEncontrado.get().setEstado(enderecoRequest.getEstado());
                enderecoEncontrado.get().setCep(enderecoRequest.getCep());

                Endereco enderecoAtualizado = enderecoRepository.save(enderecoEncontrado.get());

                return ResponseEntity.ok(new EnderecoResponseDto(enderecoAtualizado));
            }
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.badRequest().build();
    }

    public ResponseEntity<EnderecoResponseDto> deletarEndereco(Long id) {

        if (!ObjectUtils.isEmpty(id)) {

            final var enderecoEncontrado = enderecoRepository.findById(id);

            if (!enderecoEncontrado.isEmpty()) {

                enderecoRepository.deleteById(id);

                return ResponseEntity.ok().build();
            }
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
