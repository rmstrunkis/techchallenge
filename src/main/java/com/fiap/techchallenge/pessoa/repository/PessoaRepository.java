package com.fiap.techchallenge.pessoa.repository;


import com.fiap.techchallenge.pessoa.domain.Endereco;
import com.fiap.techchallenge.pessoa.domain.Pessoa;
import com.fiap.techchallenge.pessoa.domain.PessoaParentesco;
import com.fiap.techchallenge.pessoa.domain.PessoaSexo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PessoaRepository  extends JpaRepository<Pessoa, Long> {
    Optional<Pessoa> findByNomeAndParentescoAndSexo(String nome, PessoaParentesco parentesco, PessoaSexo sexo);
}
