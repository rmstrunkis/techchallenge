package com.fiap.techchallenge.pessoa.domain.request;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.fiap.techchallenge.pessoa.domain.PessoaParentesco;
import com.fiap.techchallenge.pessoa.domain.PessoaSexo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Representa um objeto de requisicao de pessoas")
public class PessoaRequest {

    @ApiModelProperty(value = "Informacao do ID do Usuário ao qual a pessoa estará vinculada", example = "1", position = 1)
    private Long idUsuario;

    @ApiModelProperty(value = "Informacao do CPF da pessoa", example = "57566310038", position = 1)
    @CPF(message = "CPF deve ser válido")
    @NotBlank(message = "CPF é Obrigatório")
    private String cpf;

    @ApiModelProperty(value = "Informacao do Nome da pessoa", example = "Zezinho", position = 1)
    @NotBlank(message = "O nome da pessoa nao pode ser vazio ou nulo.")
    private String nome;

    @ApiModelProperty(value = "Informacao do Nome do Pai da pessoa", example = "Ze", position = 1)
    private String nomePai;

    @ApiModelProperty(value = "Informacao do Nome da Mae da pessoa", example = "Zinha", position = 1)
    private String nomeMae;

    @ApiModelProperty(value = "Informacao do telefone da pessoa", example = "11 3258-5303", position = 1)
    private String telefone;

    @ApiModelProperty(value = "Informacao da senha da pessoa", example = "123", position = 1)
    @NotBlank(message = "A senha da pessoa nao pode ser vazio ou nulo.")
    private String senha;

    @ApiModelProperty(value = "Informacao da data de nascimento da pessoa", example = "01/01/2000", position = 1)
    @Past(message = "Data de nascimento deve ser maior que a Data Atual")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @ApiModelProperty(value = "Informacao do email da pessoa", example = "xs@hotmail.com", position = 1)
    @Email(message = "Email deve ser válido")
    private String email;

    @ApiModelProperty(value = "Informacao do Parentesco da pessoa com, o usuario", example = "FILHOS", position = 1)
    @NotBlank(message = "O parentesco da pessoa nao pode ser vazio ou nulo.")
    private String parentesco;

    @ApiModelProperty(value = "Informacao do Sexo da pessoa", example = "MASCULINO", position = 1)
    @NotNull(message = "Sexo deve ser informado")
    private String sexo;

}
