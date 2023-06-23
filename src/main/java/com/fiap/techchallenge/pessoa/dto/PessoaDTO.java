package com.fiap.techchallenge.pessoa.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fiap.techchallenge.pessoa.model.Pessoa;
import com.fiap.techchallenge.pessoa.model.PessoaParentesco;
import com.fiap.techchallenge.pessoa.model.PessoaSexo;
import lombok.Getter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Getter
public class PessoaDTO {
    @JsonIgnore
    private Long id;
    @NotNull(message = "Usuário é Obrigatório")
    private Long idUsuario;
    @CPF(message = "CPF deve ser válido")
    @NotBlank(message = "CPF é Obrigatório")
    private String cpf;
    @NotBlank(message = "Nome é Obrigatório")
    private String nome;
    private String nomePai;
    private String nomeMae;
    private String telefone;
    @NotBlank(message = "Senha é Obrigatória")
    private String senha;
    @Past(message = "Data de nascimento deve ser maior que a Data Atual")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;
    @Email(message = "Email deve ser válido")
    private String email;

    @NotNull(message = "Parentesco deve ser informado")
    private PessoaParentesco parentesco;

    @NotNull(message = "Sexo deve ser informado")
    private PessoaSexo sexo;

    public void SetId(Long id) {
        this.id = id;
    }
    public Pessoa toPessoa(){


        Pessoa pessoa = new Pessoa(this.id,
                this.idUsuario,
                this.cpf,
                this.nome,
                this.nomePai,
                this.nomeMae,
                this.telefone,
                this.senha,
                this.dataNascimento,
                this.email,
                this.parentesco,
                this.sexo);


        return pessoa;
    }
}
