package com.fiap.techchallenge.pessoa.service;

import com.fiap.techchallenge.pessoa.dto.PessoaDTO;
import com.fiap.techchallenge.pessoa.model.Pessoa;
import com.fiap.techchallenge.pessoa.repository.RepositorioPessoa;
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
    RepositorioPessoa repositorioPessoa;
    @Autowired
    private Validator validator;
    public ResponseEntity<String> criarNovaPessoa(PessoaDTO pessoaDTO)
    {

        String retorno;
        Optional<Pessoa> pessoaOptional = repositorioPessoa.buscar(pessoaDTO.getIdUsuario(), pessoaDTO.getCpf());

        if(pessoaOptional.isEmpty())
        {
            Long id;
            id = new Random().nextLong();
            pessoaDTO.SetId(id);

            Pessoa pessoa = pessoaDTO.toPessoa();
            repositorioPessoa.salvar(pessoa);
            retorno = "Pessoa cadastrada com ID:" + pessoa.getId();
            return ResponseEntity.status(HttpStatus.CREATED).body(retorno);
        }
        else
        {
            retorno =  "Pessoa ja cadastrada, com o ID:" + pessoaOptional.get().getId() + " para o usuário: " + pessoaDTO.getIdUsuario() ;
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
