package com.fiap.techchallenge.pessoa.repository;

import com.fiap.techchallenge.pessoa.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
