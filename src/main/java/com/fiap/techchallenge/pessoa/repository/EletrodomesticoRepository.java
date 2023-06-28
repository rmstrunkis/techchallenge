package com.fiap.techchallenge.pessoa.repository;


import com.fiap.techchallenge.pessoa.domain.Eletrodomestico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EletrodomesticoRepository extends JpaRepository<Eletrodomestico, Long> {

    Optional<Eletrodomestico> findById(Long id);

    Optional<Eletrodomestico> findByNomeAndModeloAndSerialNumber(String nome, String modelo, String serialNumber);

}
