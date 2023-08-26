package com.fiap.techchallenge.pessoa.repository;

import com.fiap.techchallenge.pessoa.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
