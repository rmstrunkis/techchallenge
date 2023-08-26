package com.fiap.techchallenge.pessoa.domain;

import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Table(name = "tb_usuario")
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeUsuario;
    private String password;
    @OneToOne(mappedBy = "usuario")
    private Pessoa pessoa;

    public Usuario() {}

    public Usuario(String nomeUsuario, String password) {
        this.nomeUsuario = nomeUsuario;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
