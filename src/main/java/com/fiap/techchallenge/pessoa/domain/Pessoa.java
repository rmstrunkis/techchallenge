package com.fiap.techchallenge.pessoa.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(of = {"cpf","idUsuario"})
public class Pessoa  {

    private Long id;
    private Long idUsuario;
    private String cpf;
    private String nome;
    private String nomePai;
    private String nomeMae;
    private String telefone;
    private String senha;
    private LocalDate dataNascimento;
    private String email;
    private PessoaParentesco parentesco;
    private PessoaSexo sexo;

    public boolean identificadaPor(Long idUsuario, String cpf) {
        return  this.cpf.equals(cpf)
                && this.idUsuario.equals(idUsuario);
    }
}
