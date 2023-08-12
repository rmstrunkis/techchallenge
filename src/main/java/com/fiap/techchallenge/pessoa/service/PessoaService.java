package com.fiap.techchallenge.pessoa.service;

import com.fiap.techchallenge.pessoa.config.ValidatorBean;
import com.fiap.techchallenge.pessoa.domain.request.PessoaRequest;
import com.fiap.techchallenge.pessoa.domain.Pessoa;
import com.fiap.techchallenge.pessoa.domain.response.dto.PessoaResponseDto;
import com.fiap.techchallenge.pessoa.repository.PessoaRepository;
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
public class PessoaService {
    private static final String BAD_REQUEST_VAZIO = "As informacoes do resquest sao nulas ou o cadastro ja existe.";

    private static Logger logger = LoggerFactory.getLogger(PessoaService.class);


    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired
    private ValidatorBean validator;

    public ResponseEntity cadastrarPessoa(PessoaRequest pessoaRequest) {
        final var validar = validator.validar(pessoaRequest);
        final var pessoaEncontrada = pessoaRepository.findByNomeAndParentescoAndSexo(
                pessoaRequest.getNome(), pessoaRequest.getParentesco(), pessoaRequest.getSexo());

        if (pessoaEncontrada.isEmpty() && validar.isEmpty()) {
            Pessoa pessoa = new Pessoa();
            pessoa.setIdUsuario(pessoaRequest.getIdUsuario());
            pessoa.setCpf(pessoaRequest.getCpf());
            pessoa.setNome(pessoaRequest.getNome());
            pessoa.setNomePai(pessoaRequest.getNomePai());
            pessoa.setNomeMae(pessoaRequest.getNomeMae());
            pessoa.setTelefone(pessoaRequest.getTelefone());
            pessoa.setSenha(pessoaRequest.getSenha());
            pessoa.setDataNascimento(pessoaRequest.getDataNascimento());
            pessoa.setEmail(pessoaRequest.getEmail());
            pessoa.setParentesco(pessoaRequest.getParentesco());
            pessoa.setSexo(pessoaRequest.getSexo());

            Pessoa pessoaSalva = pessoaRepository.save(pessoa);

            logger.info("Pessoa cadastrada com sucesso.");
            return ResponseEntity.status(HttpStatus.CREATED).body(new PessoaResponseDto(pessoaSalva));
        }else{
            logger.info(BAD_REQUEST_VAZIO);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(BAD_REQUEST_VAZIO + validar.toString());
        }
    }

    public ResponseEntity<List<PessoaResponseDto>> consultarPessoa(Long id) {
        final var pessoaEncontrada = pessoaRepository.findById(id);

        if (!pessoaEncontrada.isEmpty()) {
            List<PessoaResponseDto> listaPessoa = pessoaEncontrada.stream().map(PessoaResponseDto::new).collect(Collectors.toList());

            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<PessoaResponseDto> atualizarPessoa(PessoaRequest pessoaRequest, Long id) {
        if (!ObjectUtils.isEmpty(id)) {
            final var pessoaEncontrada = pessoaRepository.findById(id);

            if (!pessoaEncontrada.isEmpty()) {
                pessoaEncontrada.get().setIdUsuario(pessoaRequest.getIdUsuario());
                pessoaEncontrada.get().setCpf(pessoaRequest.getCpf());
                pessoaEncontrada.get().setNome(pessoaRequest.getNome());
                pessoaEncontrada.get().setNomePai(pessoaRequest.getNomePai());
                pessoaEncontrada.get().setNomeMae(pessoaRequest.getNomeMae());
                pessoaEncontrada.get().setTelefone(pessoaRequest.getTelefone());
                pessoaEncontrada.get().setSenha(pessoaRequest.getSenha());
                pessoaEncontrada.get().setDataNascimento(pessoaRequest.getDataNascimento());
                pessoaEncontrada.get().setEmail(pessoaRequest.getEmail());
                pessoaEncontrada.get().setParentesco(pessoaRequest.getParentesco());
                pessoaEncontrada.get().setSexo(pessoaRequest.getSexo());

                Pessoa pessoaAtualizada = pessoaRepository.save(pessoaEncontrada.get());
                return ResponseEntity.ok(new PessoaResponseDto(pessoaAtualizada));
            }
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.badRequest().build();
    }

    public ResponseEntity<PessoaResponseDto> deletarPessoa(Long id) {

        if (!ObjectUtils.isEmpty(id)) {
            final var pessoaEncontrada = pessoaRepository.findById(id);

            if (!pessoaEncontrada.isEmpty()) {
                pessoaRepository.deleteById(id);
                return ResponseEntity.ok().build();
            }
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.badRequest().build();
    }
}