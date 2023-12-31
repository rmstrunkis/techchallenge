package com.fiap.techchallenge.pessoa.repository;

import com.fiap.techchallenge.pessoa.domain.Pessoa;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Repository
public class PessoaRepository {
    private Set<Pessoa> pessoas;
    public PessoaRepository(){
        pessoas = new HashSet<>();
    }

    public void salvar(Pessoa pessoa)
    {
       pessoas.add(pessoa);
    }

    public Optional<Pessoa> buscar(Long idUsuario, String cpf)
    {
        return pessoas.stream()
                .filter(pessoa -> pessoa.identificadaPor(idUsuario, cpf))
                .findFirst();
    }
}
