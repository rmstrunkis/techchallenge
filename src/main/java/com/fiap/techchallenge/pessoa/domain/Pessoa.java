package com.fiap.techchallenge.pessoa.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PESSOA")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoa  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @CPF(message = "CPF deve ser válido")
    @NotBlank(message = "CPF é Obrigatório")
    @Column(name = "cpf")
    private String cpf;

    @NotBlank(message = "Nome é Obrigatório")
    @Column(name = "nome")
    private String nome;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "email")
    private String email;

    @NotBlank(message = "Senha é Obrigatória")
    @Column(name = "senha")
    private String senha;

    @NotNull(message = "Parentesco deve ser informado")
    @Column(name = "parentesco")
    private PessoaParentesco parentesco;

    @Past(message = "Data de nascimento deve ser maior que a Data Atual")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Column(name = "dataNascimento")
    private LocalDate dataNascimento;

    @NotNull(message = "Sexo deve ser informado")
    @Column(name = "sexo")
    private PessoaSexo sexo;


}
