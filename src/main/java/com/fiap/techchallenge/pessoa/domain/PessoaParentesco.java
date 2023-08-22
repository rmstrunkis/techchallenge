package com.fiap.techchallenge.pessoa.domain;

public enum PessoaParentesco {
    TITULAR ("Titular"),
    CONJUGE("Cônjuge"),
    FILHO("Filho"),
    PAIS("Pais"),
    AVOS("Avós"),
    SOGROS("Sogros"),
    BISAVOS("Bisavós"),
    NETOS("Netos"),
    IRMAOS("Irmãos"),
    TIOS("Tios"),
    SOBRINHOS("Sobrinhos"),
    PRIMOS("Primos"),
    AMIGOS("Amigos"),
    FUNCIONARIOS("Funcionários"),
    OUTROS("Outros");

    private String descricao;

    PessoaParentesco(String descricao) {
        this.descricao = descricao;
    }
    public String getDescricao() {
        return descricao;
    }
}