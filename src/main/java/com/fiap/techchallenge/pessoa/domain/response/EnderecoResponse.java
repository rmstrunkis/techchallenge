package com.fiap.techchallenge.pessoa.domain.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@ApiModel(description = "Representa um objeto de resposta da requisicao de endereço")
public class EnderecoResponse {

    @ApiModelProperty(value = "ID do cadastro do endereco", example = "1", position = 1)
    private Long id;

    @ApiModelProperty(value = "Informacao do nome da rua", example = "Rua Av Atlantica", position = 1)
    private String rua;

    @ApiModelProperty(value = "Informacao do CEP da residencia", example = "22631-000", position = 1)
    private String cep;

    @ApiModelProperty(value = "Informacao do numero da residencia", example = "8", position = 1)
    private Long numero;

    @ApiModelProperty(value = "Informacao do bairro da residencia", example = "Copacabana", position = 1)
    private String bairro;

    @ApiModelProperty(value = "Informacao do cidade da residencia", example = "Rio de Janeiro", position = 1)
    private String cidade;

    @ApiModelProperty(value = "Informacao do estado da residencia", example = "RJ", position = 1)
    private String estado;

}
