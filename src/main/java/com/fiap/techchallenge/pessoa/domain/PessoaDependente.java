package com.fiap.techchallenge.pessoa.domain;

import com.fiap.techchallenge.pessoa.domain.response.dto.PessoaDto;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PESSOA_DEPENDENTE")
public class PessoaDependente extends Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    private Long idTitular;

    @ManyToOne
    @JoinColumn(name = "idTitular")
    private Pessoa titular;

    public PessoaDto toPessoaDependenteDto() {
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
        pessoaDto.setIdTitular(this.getTitular());
        pessoaDto.setTitular(this.getTitular());
        return pessoaDto;
    }

}
