package com.fiap.techchallenge.pessoa.domain.response.dto;

import com.fiap.techchallenge.pessoa.domain.Eletrodomestico;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@ApiModel(description = "Representa um objeto de requisicao de eletrodomestico")
public class EletrodomesticoResponseDto {

    public EletrodomesticoResponseDto(Eletrodomestico eletrodomestico) {
        this.nome = eletrodomestico.getNome();
        this.modelo = eletrodomestico.getModelo();
        this.potencia = eletrodomestico.getPotencia();
        this.serialNumber = eletrodomestico.getSerialNumber();
    }

    @ApiModelProperty(value = "Informacao do nome do eletrodomestico", example = "Microondas", position = 1)
    private String nome;

    @ApiModelProperty(value = "Informacao do nome do modelo do eletrodomestico", example = "LG", position = 1)
    private String modelo;

    @ApiModelProperty(value = "Informacao da potencia do eletrodomestico", example = "900W", position = 1)
    private String potencia;

    @ApiModelProperty(value = "Informacao do serial number do eletrodomestico", example = "GN20142B530", position = 1)
    private String serialNumber;

}
