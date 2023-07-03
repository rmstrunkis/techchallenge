package com.fiap.techchallenge.pessoa.domain.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@ApiModel(description = "Representa um objeto de requisicao de eletrodomestico")
public class EletrodomesticoResponse {

    @ApiModelProperty(value = "Informacao do nome do eletrodomestico", example = "Microondas", position = 1)
    private String nome;

    @ApiModelProperty(value = "Informacao do nome do modelo do eletrodomestico", example = "LG", position = 1)
    private String modelo;

    @ApiModelProperty(value = "Informacao da potencia do eletrodomestico", example = "900W", position = 1)
    private String potencia;

    @ApiModelProperty(value = "Informacao do serial number do eletrodomestico", example = "GN20142B530", position = 1)
    private String serialNumber;

}
