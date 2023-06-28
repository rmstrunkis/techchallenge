package com.fiap.techchallenge.pessoa.service;

import com.fiap.techchallenge.pessoa.domain.request.PessoaRequest;
import com.fiap.techchallenge.pessoa.domain.Pessoa;
import com.fiap.techchallenge.pessoa.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Path;
import javax.validation.Validator;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PessoaService {
    @Autowired
    PessoaRepository pessoaRepository;
    @Autowired
    private Validator validator;
    public ResponseEntity<String> criarNovaPessoa(PessoaRequest pessoaRequest)
    {

        String retorno;
        Optional<Pessoa> pessoaOptional = pessoaRepository.buscar(pessoaRequest.getIdUsuario(), pessoaRequest.getCpf());

        if(pessoaOptional.isEmpty())
        {
            Long id;
            id = new Random().nextLong();
            pessoaRequest.SetId(id);

            Pessoa pessoa = pessoaRequest.toPessoa();
            pessoaRepository.salvar(pessoa);
            retorno = "Pessoa cadastrada com ID:" + pessoa.getId();
            return ResponseEntity.status(HttpStatus.CREATED).body(retorno);
        }
        else
        {
            retorno =  "Pessoa ja cadastrada, com o ID:" + pessoaOptional.get().getId() + " para o usuário: " + pessoaRequest.getIdUsuario() ;
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(retorno);

        }

    }

    public <T> Map<Path, String> validar(T dto) {
        Set<ConstraintViolation<T>> violacoes
                = validator.validate(dto);

        Map<Path, String>  violacoesToMap = violacoes
                .stream()
                .collect(Collectors.toMap(
                        violacao ->violacao.getPropertyPath(), ConstraintViolation::getMessage));
        return violacoesToMap;
    }
}
