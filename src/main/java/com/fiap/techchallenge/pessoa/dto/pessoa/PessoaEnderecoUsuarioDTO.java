package com.fiap.techchallenge.pessoa.dto.pessoa;

import com.fiap.techchallenge.pessoa.domain.Pessoa;
import com.fiap.techchallenge.pessoa.dto.pessoa.usuario.UsuarioDTO;
import lombok.Getter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
public class PessoaEnderecoUsuarioDTO {
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
    private Set<EnderecoDTO> enderecos;

    public PessoaEnderecoUsuarioDTO(
            Long id,
            String cpf,
            String nome,
            String telefone,
            String email,
            String senha,
            LocalDate dataNascimento,
            String sexo,
            String parentesco,
            UsuarioDTO usuario,
            Set<EnderecoDTO> enderecos
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
        this.enderecos = enderecos;
    }

    public static PessoaEnderecoUsuarioDTO fromEntity(Pessoa pessoa) {
        Set<EnderecoDTO> enderecos = new HashSet<>();

        if(!pessoa.getEnderecos().isEmpty()) {
            pessoa.getEnderecos().forEach( endereco -> {
                enderecos.add(EnderecoDTO.fromEntity(endereco));
            });
        }

        return  new PessoaEnderecoUsuarioDTO(
                pessoa.getId(),
                pessoa.getCpf(),
                pessoa.getNome(),
                pessoa.getTelefone(),
                pessoa.getEmail(),
                pessoa.getSenha(),
                pessoa.getDataNascimento(),
                pessoa.getSexo(),
                pessoa.getParentesco(),
                enderecos,
                pessoa.getUsuario() != null ? new UsuarioDTO(pessoa.getUsuario()) : null
        );
    }
}
