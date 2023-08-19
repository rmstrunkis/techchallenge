package com.fiap.techchallenge.pessoa.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PESSOA")
public abstract class Pessoa  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "nome")
    private String nome;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    @Column(name = "parentesco")
    private PessoaParentesco parentesco;

    @Column(name = "dataNascimento")
    private LocalDate dataNascimento;

    @Column(name = "sexo")
    private PessoaSexo sexo;


}
