package com.fiap.techchallenge.pessoa.service;

import com.fiap.techchallenge.pessoa.dto.PessoaDTO;
import com.fiap.techchallenge.pessoa.model.Pessoa;
import com.fiap.techchallenge.pessoa.repository.RespositorioPessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Path;
import javax.validation.Validator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PessoaService {
    @Autowired
    RespositorioPessoa repositorioPessoa;
    @Autowired
    private Validator validator;
    public Pessoa criarNovaPessoa(PessoaDTO pessoaDTO)
    {
        Pessoa pessoa = pessoaDTO.toPessoa();
        repositorioPessoa.salvar(pessoa);
        return pessoa;
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
