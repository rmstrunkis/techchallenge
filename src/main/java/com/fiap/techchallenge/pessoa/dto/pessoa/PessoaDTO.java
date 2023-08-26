package com.fiap.techchallenge.pessoa.dto.pessoa;

import com.fiap.techchallenge.pessoa.domain.Pessoa;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
@Getter

public class PessoaDTO {
    private final Long id;
    @NotBlank(message = "O CPF não pode estar em branco")
    @CPF(message = "CPF inválido")
    private final String cpf;
    private final String nome;
    private final String telefone;
    @Email(message = "O email deve estar em um formato válido")
    private final String email;
    private final String senha;
    private final LocalDate dataNascimento;
    private final String sexo;
    private final String parentesco;


    public PessoaDTO(Long id,
                     String cpf,
                     String nome,
                     String telefone,
                     String email,
                     String senha,
                     LocalDate dataNascimento,
                     String sexo,
                     String parentesco) {
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

    public PessoaDTO(Pessoa pessoa) {
        this(
                pessoa.getId(),
                pessoa.getCpf(),
                pessoa.getNome(),
                pessoa.getTelefone(),
                pessoa.getEmail(),
                pessoa.getSenha(),
                pessoa.getDataNascimento(),
                pessoa.getSexo(),
                pessoa.getParentesco());
    }
    public static Pessoa toEntity(PessoaDTO dto) {
        return new Pessoa(dto);
    }
    public static PessoaDTO fromEntity(Pessoa pessoa) {
        return  new PessoaDTO(
                pessoa.getId(),
                pessoa.getCpf(),
                pessoa.getNome(),
                pessoa.getTelefone(),
                pessoa.getEmail(),
                pessoa.getSenha(),
                pessoa.getDataNascimento(),
                pessoa.getSexo(),
                pessoa.getParentesco()
        );
    }
    public static Pessoa mapperDtoToEntity(
            PessoaDTO dto,
            Pessoa entity) {
        entity.setCpf(dto.getCpf());
        entity.setNome(dto.getNome());
        entity.setTelefone(dto.getTelefone());
        entity.setEmail(dto.getEmail());
        entity.setSenha(dto.getSenha());
        entity.setDataNascimento(dto.getDataNascimento());
        entity.setSexo(dto.getSexo());
        entity.setParentesco(dto.getParentesco());

        return entity;
    }
}
