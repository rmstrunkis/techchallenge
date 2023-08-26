package com.fiap.techchallenge.pessoa.domain;

import com.fiap.techchallenge.pessoa.dto.pessoa.PessoaDTO;
import com.fiap.techchallenge.pessoa.dto.pessoa.PessoaUsuarioDTO;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Table(name = "tb_pessoa")
@Entity
@EqualsAndHashCode(of = {"id"})
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cpf;
    private String nome;
    private String telefone;
    private String email;
    private String senha;
    private LocalDate dataNascimento;
    private String sexo;
    private String parentesco;
    @OneToMany(mappedBy = "pessoa")
    private Set<Endereco> enderecos = new HashSet<>();
    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Pessoa() {
    }

    public Pessoa(
            Long id,
            String cpf,
            String nome,
            String telefone,
            String email,
            String senha,
            LocalDate dataNascimento,
            String sexo,
            String parentesco

    ) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.parentesco = parentesco;
    }

    public Pessoa(PessoaDTO dto) {
        this.id = dto.id();
        this.cpf = dto.cpf();
        this.nome = dto.nome();
        this.telefone = dto.telefone();
        this.email = dto.email();
        this.senha = dto.senha();
        this.dataNascimento = dto.dataNascimento();
        this.sexo = dto.sexo();
        this.parentesco = dto.parentesco();

    }

    public Pessoa(PessoaUsuarioDTO dto, Usuario usuario) {
        this.id = dto.id();
        this.cpf = dto.cpf();
        this.nome = dto.nome();
        this.telefone = dto.telefone();
        this.email = dto.email();
        this.senha = dto.senha();
        this.dataNascimento = dto.dataNascimento();
        this.sexo = dto.sexo();
        this.parentesco = dto.parentesco();
        this.usuario = usuario;
    }


    public Long getId() {
        return id;
    }

    public Pessoa setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public Pessoa setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getTelefone() {
        return telefone;
    }

    public Pessoa setTelefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Pessoa setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
        return this;
    }

    public String getSexo() {
        return sexo;
    }

    public Pessoa setSexo(String sexo) {
        this.sexo = sexo;
        return this;
    }

    public String getParentesco() {
        return parentesco;
    }

    public Pessoa setParentesco(String parentesco) {
        this.parentesco = parentesco;
        return this;
    }
    public Set<Endereco> getEnderecos() {
        return enderecos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", sexo='" + sexo + '\'' +
                ", parentesco='" + parentesco + '\'' +
                '}';
    }
}
