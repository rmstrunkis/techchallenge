package com.fiap.techchallenge.pessoa.dto.pessoa.usuario;

import com.fiap.techchallenge.pessoa.domain.Usuario;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UsuarioDTO {
    private long id;
    @NotBlank(message = "O nome de usuário não pode estar em branco")
    private String nomeUsuario;
    @NotBlank(message = "O password não pode estar em branco")
    @Size(min = 8, message = "A senha deve ter pelo menos {min} caracteres")
    private String password;

    public UsuarioDTO(long id, String nomeUsuario, String password) {
        this.id = id;
        this.nomeUsuario = nomeUsuario;
        this.password = password;
    }
    public UsuarioDTO(Usuario usuario) {
        this(usuario.getId(), usuario.getNomeUsuario(), usuario.getPassword());
    }
    public  static  UsuarioDTO fromEntity(Usuario usuario) {
        return new UsuarioDTO(
                usuario.getId(),
                usuario.getNomeUsuario(),
                usuario.getPassword()
        );
    }
    public static Usuario toEntity(UsuarioDTO usuarioDTO) {
        return  new Usuario(
                usuarioDTO.nomeUsuario,
                usuarioDTO.password
        );
    }
    public static  Usuario mapperDtoToEntity(
            UsuarioDTO usuarioDTO,
            Usuario usuario
    ) {
        usuario.setNomeUsuario(usuarioDTO.nomeUsuario);
        usuario.setPassword(usuarioDTO.password);
        return  usuario;
    }
}
