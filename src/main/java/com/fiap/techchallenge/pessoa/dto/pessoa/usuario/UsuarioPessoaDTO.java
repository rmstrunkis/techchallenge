package com.fiap.techchallenge.pessoa.dto.pessoa.usuario;

import com.fiap.techchallenge.pessoa.domain.Usuario;
import com.fiap.techchallenge.pessoa.dto.pessoa.PessoaDTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class UsuarioPessoaDTO {

    private long id;
    @NotBlank(message = "O nome de usuário não pode estar em branco")
    private String nomeUsuario;
    @NotBlank(message = "O password não pode estar em branco")
    @Size(min = 8, message = "A senha deve ter pelo menos {min} caracteres")
    private String password;
    private PessoaDTO pessoa;

    public UsuarioPessoaDTO(long id, String nomeUsuario, String password, PessoaDTO pessoa) {
        this.id = id;
        this.nomeUsuario = nomeUsuario;
        this.password = password;
        this.pessoa = pessoa;
    }

    public  static UsuarioPessoaDTO fromEntity(Usuario usuario) {
        return new UsuarioPessoaDTO(
                usuario.getId(),
                usuario.getNomeUsuario(),
                usuario.getPassword(),
                usuario.getPessoa() != null ? new PessoaDTO(usuario.getPessoa()) : null
        );
    }
}
