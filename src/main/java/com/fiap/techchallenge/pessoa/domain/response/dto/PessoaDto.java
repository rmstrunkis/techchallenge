package com.fiap.techchallenge.pessoa.domain.response.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
@ApiModel(description = "Representa um objeto de resposta da requisicao de endereço")
public class PessoaDto {
    public PessoaDto(
            Long id, String cpf, String nome, String telefone, String email, String senha, LocalDate dataNascimento, String sexo,
            String parentesco, Long idPessoaTitular, String dtype
    ) {
        // atribui os parâmetros aos campos da classe
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.parentesco = parentesco;
        this.idPessoaTitular = idPessoaTitular;
        this.dtype = dtype;
    }
    @ApiModelProperty(value = "ID do cadastro de pessoa", example = "1", position = 1)
    private Long id;

    @ApiModelProperty(value = "Informacao do CPF da pessoa", example = "57566310038", position = 1)
    private String cpf;

    @ApiModelProperty(value = "Informacao do Nome da pessoa", example = "Zezinho", position = 1)
    private String nome;

    @ApiModelProperty(value = "Informacao do Nome do Pai da pessoa", example = "Ze", position = 1)
    private String telefone;

    @ApiModelProperty(value = "Informacao do email da pessoa", example = "xs@hotmail.com", position = 1)
    private String email;

    @ApiModelProperty(value = "Informacao da senha da pessoa", example = "123", position = 1)
    private String senha;

    @ApiModelProperty(value = "Informacao da data de nascimento da pessoa", example = "01/01/2000", position = 1)
    private LocalDate dataNascimento;

    @ApiModelProperty(value = "Informacao do Sexo da pessoa", example = "MASCULINO", position = 1)
    private String sexo;

    @ApiModelProperty(value = "Informacao do Parentesco da pessoa com, o titular", example = "FILHOS", position = 1)
    private String parentesco;

    @ApiModelProperty(value = "Informacao o id da pessoa titular", example = "FILHOS", position = 1)
    private Long idPessoaTitular;


    private String dtype;

    public PessoaDto() {

    }

}
