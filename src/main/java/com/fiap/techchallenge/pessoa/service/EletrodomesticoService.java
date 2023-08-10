package com.fiap.techchallenge.pessoa.service;

import com.fiap.techchallenge.pessoa.config.ValidatorBean;
import com.fiap.techchallenge.pessoa.domain.Eletrodomestico;
import com.fiap.techchallenge.pessoa.domain.Endereco;
import com.fiap.techchallenge.pessoa.domain.request.EletrodomesticoRequest;
import com.fiap.techchallenge.pessoa.domain.request.EnderecoRequest;
import com.fiap.techchallenge.pessoa.domain.response.dto.EletrodomesticoResponseDto;
import com.fiap.techchallenge.pessoa.domain.response.dto.EnderecoResponseDto;
import com.fiap.techchallenge.pessoa.repository.EletrodomesticoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EletrodomesticoService {

    private static final String BAD_REQUEST_VAZIO = "As informacoes do resquest sao nulas ou o cadastro ja existe.";

    private static Logger logger = LoggerFactory.getLogger(EletrodomesticoService.class);

    @Autowired
    EletrodomesticoRepository eletrodomesticoRepository;

    @Autowired
    private ValidatorBean validator;

    public ResponseEntity cadastrarEletrodomestico (EletrodomesticoRequest eletrodomesticoRequest){

        final var validar = validator.validar(eletrodomesticoRequest);
        final var enderecoEncontrado = eletrodomesticoRepository.findByNomeAndModeloAndSerialNumber(
                eletrodomesticoRequest.getNome(), eletrodomesticoRequest.getModelo(), eletrodomesticoRequest.getSerialNumber());

        if(enderecoEncontrado.isEmpty() && validar.isEmpty()) {
            Eletrodomestico eletrodomestico = new Eletrodomestico();
            eletrodomestico.setNome(eletrodomesticoRequest.getNome());
            eletrodomestico.setModelo(eletrodomesticoRequest.getModelo());
            eletrodomestico.setPotencia(eletrodomesticoRequest.getPotencia());
            eletrodomestico.setSerialNumber(eletrodomesticoRequest.getSerialNumber());

            Eletrodomestico eletrodomesticoSalvo = eletrodomesticoRepository.save(eletrodomestico);

            logger.info("Eletrodomestico cadastrado com sucesso.");
            return ResponseEntity.status(HttpStatus.CREATED).body(new EletrodomesticoResponseDto(eletrodomesticoSalvo));
        } else {
            logger.info(BAD_REQUEST_VAZIO);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(BAD_REQUEST_VAZIO + validar.toString());
        }

    }

    public ResponseEntity<List<EletrodomesticoResponseDto>> consultarEletrodomestico (Long id) {

        final var eletrodomesticoEncontrado = eletrodomesticoRepository.findById(id);

        if (!eletrodomesticoEncontrado.isEmpty()) {

            List<EletrodomesticoResponseDto> listaEletrodomesticoEncontrado = eletrodomesticoEncontrado.stream().map(EletrodomesticoResponseDto::new).collect(Collectors.toList());

            return ResponseEntity.ok(listaEletrodomesticoEncontrado);
        }
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<EletrodomesticoResponseDto> atualizarEletrodomestico(EletrodomesticoRequest eletrodomesticoRequest, Long id) {

        if (!ObjectUtils.isEmpty(id)) {

            final var eletrodomesticoEncontrado = eletrodomesticoRepository.findById(id);

            if (!eletrodomesticoEncontrado.isEmpty()) {

                eletrodomesticoEncontrado.get().setNome(eletrodomesticoRequest.getNome());
                eletrodomesticoEncontrado.get().setModelo(eletrodomesticoRequest.getModelo());
                eletrodomesticoEncontrado.get().setPotencia(eletrodomesticoRequest.getPotencia());
                eletrodomesticoEncontrado.get().setSerialNumber(eletrodomesticoRequest.getSerialNumber());

                Eletrodomestico eletrodomesticoAtualizado = eletrodomesticoRepository.save(eletrodomesticoEncontrado.get());

                return ResponseEntity.ok(new EletrodomesticoResponseDto(eletrodomesticoAtualizado));
            }
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.badRequest().build();
    }

    public ResponseEntity<EletrodomesticoResponseDto> deletarEletrodomestico(Long id) {

        if (!ObjectUtils.isEmpty(id)) {

            final var eletrodomesticoEncontrado = eletrodomesticoRepository.findById(id);

            if (!eletrodomesticoEncontrado.isEmpty()) {

                eletrodomesticoRepository.deleteById(id);

                return ResponseEntity.ok().build();
            }
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.badRequest().build();
    }

}
