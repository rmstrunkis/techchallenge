package com.fiap.techchallenge.pessoa.repository;

import com.fiap.techchallenge.pessoa.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    Optional<Pessoa> findById(Long id);

    Optional<Pessoa> findByNomeAndParentescoAndSexo(String nome, String parentesco, String sexo);
}
