package com.fiap.techchallenge.pessoa.repository;


import com.fiap.techchallenge.pessoa.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    Optional<Endereco> findById(Long id);

    Optional<Endereco> findByRuaAndNumero(String rua, Long numero);

}
