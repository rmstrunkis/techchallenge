package com.fiap.techchallenge.pessoa.dto.pessoa;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class EnderecoDTO {
    private Long id;
    @NotBlank(message = "A rua não pode estar em branco")
    private String rua;
    @NotBlank(message = "A cidade não pode estar em branco")

    @Column(name = "numero")
    private Long numero;

    @Pattern(regexp = "\\d{5}-\\d{3}", message = "O CEP deve ertar no formato 00000-000")
    private String cep;

    @Column(name = "bairro")
    private String bairro;

    @NotBlank(message = "A cidade não pode estar em branco")
    String cidade;

    @NotBlank(message = "O estado não pode estar em branco")
    @Size(min = 2, max =2 , message = "O estado deve ter exatamente 2 caracteres")
    String estado;


}
