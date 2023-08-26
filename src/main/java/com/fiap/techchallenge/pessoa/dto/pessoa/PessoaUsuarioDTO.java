package com.fiap.techchallenge.pessoa.dto.pessoa;

import com.fiap.techchallenge.pessoa.domain.Pessoa;
import com.fiap.techchallenge.pessoa.domain.Usuario;
import com.fiap.techchallenge.pessoa.dto.pessoa.usuario.UsuarioDTO;
import jdk.jshell.Snippet;
import lombok.Getter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
@Getter
public class PessoaUsuarioDTO {
    private Long id;
    @NotBlank(message = "O CPF não pode estar em branco")
    @CPF(message = "CPF inválido")
    private String cpf;
    private String nome;
    private String telefone;
    @Email(message = "O email deve estar em um formato válido")
    private String email;
    private String senha;
    private LocalDate dataNascimento;
    private String sexo;
    private String parentesco;
    private UsuarioDTO usuario;

    public PessoaUsuarioDTO(
            Long id,
            String cpf,
            String nome,
            String telefone,
            String email,
            String senha,
            LocalDate dataNascimento,
            String sexo,
            String parentesco,
            UsuarioDTO usuario
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
        this.usuario = usuario;
    }

    public static Pessoa toEntity(PessoaUsuarioDTO dto, Usuario usuario) {
        return new Pessoa(dto, usuario);
    }
    public static PessoaUsuarioDTO fromEntity(Pessoa pessoa) {
        return  new PessoaUsuarioDTO(
                pessoa.getId(),
                pessoa.getCpf(),
                pessoa.getNome(),
                pessoa.getTelefone(),
                pessoa.getEmail(),
                pessoa.getSenha(),
                pessoa.getDataNascimento(),
                pessoa.getSexo(),
                pessoa.getParentesco(),
                pessoa.getUsuario() != null ? new UsuarioDTO(pessoa.getUsuario()) : null

        );
    }
    public static Pessoa mapperDtoToEntity(
            PessoaUsuarioDTO dto,
            Pessoa entity,
            Usuario usuario) {
        entity.setCpf(dto.getCpf());
        entity.setNome(dto.getNome());
        entity.setTelefone(dto.getTelefone());
        entity.setEmail(dto.getEmail());
        entity.setSenha(dto.getSenha());
        entity.setDataNascimento(dto.getDataNascimento());
        entity.setSexo(dto.getSexo());
        entity.setParentesco(dto.getParentesco());
        entity.setUsuario(usuario);
        return entity;
    }

}
