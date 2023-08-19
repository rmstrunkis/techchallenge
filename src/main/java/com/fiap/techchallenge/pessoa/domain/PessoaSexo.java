package com.fiap.techchallenge.pessoa.domain;

public enum PessoaSexo {
    MASCULINO ("Masculino"),
    FEMININO ("Feminino");

    private String descricao;

    PessoaSexo (String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
