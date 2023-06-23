package com.fiap.techchallenge.pessoa.repository;

import com.fiap.techchallenge.pessoa.model.Pessoa;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class RespositorioPessoa {
    private Set<Pessoa> pessoas;
    public RespositorioPessoa(){
        pessoas = new HashSet<>();
    }
    public void salvar(Pessoa pessoa){
        pessoas.add(pessoa);
    }
}
