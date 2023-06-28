package com.fiap.techchallenge.pessoa.domain.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Representa um objeto de requisicao de endereço")
public class EnderecoRequest {

    @NotBlank(message = "O nome da rua nao pode ser vazio ou nulo.")
    @ApiModelProperty(value = "Informacao do nome da rua", example = "Rua A", position = 1)
    private String rua;

    @NotNull(message = "O numero nao pode ser nulo.")
    @ApiModelProperty(value = "Informacao do numero da residencia", example = "1", position = 1)
    private Long numero;

    @Pattern(regexp = "^[0-9]{1,5}\\-[0-9]{1,3}$", message = "O CEP deve ter o formato 00000-000.")
    @NotBlank(message = "O nome CEP pode ser vazio ou nulo.")
    @ApiModelProperty(value = "Informacao do CEP da residencia", example = "22631-000", position = 1)
    private String cep;

    @NotBlank(message = "O nome do bairro da rua nao pode ser vazio ou nulo.")
    @ApiModelProperty(value = "Informacao do bairro da residencia", example = "Copacabana", position = 1)
    private String bairro;

    @NotBlank(message = "O nome da cidade da rua nao pode ser vazio ou nulo.")
    @ApiModelProperty(value = "Informacao do cidade da residencia", example = "Rio de Janeiro", position = 1)
    private String cidade;

    @NotBlank(message = "O nome do estado da rua nao pode ser vazio ou nulo.")
    @ApiModelProperty(value = "Informacao do estado da residencia", example = "RJ", position = 1)
    private String estado;

}
