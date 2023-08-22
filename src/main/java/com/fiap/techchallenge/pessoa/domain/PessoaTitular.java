package com.fiap.techchallenge.pessoa.domain;

import com.fiap.techchallenge.pessoa.domain.response.dto.PessoaDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PESSOA_TITULAR")
public class PessoaTitular extends Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToMany(mappedBy = "titular")
    private Set<Pessoa> dependentes;

    @Column(name = "idTitular")
    private Long idTitular = 0L;

    public PessoaDto toPessoaTitularDto() {
        PessoaDto pessoaDto = new PessoaDto();
        pessoaDto.setId(this.getId());
        pessoaDto.setCpf(this.getCpf());
        pessoaDto.setNome(this.getNome());
        pessoaDto.setTelefone(this.getTelefone());
        pessoaDto.setEmail(this.getEmail());
        pessoaDto.setSenha(this.getSenha());
        pessoaDto.setParentesco(this.getParentesco().getDescricao());
        pessoaDto.setDataNascimento(this.getDataNascimento());
        pessoaDto.setSexo(this.getSexo().getDescricao());
        pessoaDto.setDependentes(this.getDependentes());
        pessoaDto.setIdTitular(this.getIdTitular());
        return pessoaDto;
    }
}
