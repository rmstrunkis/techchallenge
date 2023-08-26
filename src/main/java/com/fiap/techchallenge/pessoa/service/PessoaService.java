package com.fiap.techchallenge.pessoa.service;

import com.fiap.techchallenge.pessoa.domain.Pessoa;
import com.fiap.techchallenge.pessoa.domain.Usuario;
import com.fiap.techchallenge.pessoa.dto.pessoa.PessoaUsuarioDTO;
import com.fiap.techchallenge.pessoa.repository.PessoaRepository;
import com.fiap.techchallenge.pessoa.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;


@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository, UsuarioRepository usuarioRepository) {
        this.pessoaRepository = pessoaRepository;
        this.usuarioRepository = usuarioRepository;
    }
    @Transactional(readOnly = true)
    public Page<PessoaUsuarioDTO> findAll(PageRequest pageRequest) {
        var enderecos = pessoaRepository.findAll(pageRequest);
        return enderecos.map(PessoaUsuarioDTO::fromEntity);
    }
    @Transactional(readOnly = true)
    public PessoaUsuarioDTO findById(Long id) {
        var endereco = pessoaRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Pessoa não encontrada")
        );

        return PessoaUsuarioDTO.fromEntity(endereco);
    }
    @Transactional
    public PessoaUsuarioDTO save(PessoaUsuarioDTO dto) {
        try {
            var usuario = usuarioRepository.getReferenceById(dto.usuario().id());
            var entity = PessoaUsuarioDTO.toEntity(dto, usuario);
            var enderecoSaved = pessoaRepository.save(entity);
            return PessoaUsuarioDTO.fromEntity(enderecoSaved);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    @Transactional
    public PessoaUsuarioDTO update(Long id, PessoaUsuarioDTO dto) {
        try {
            var usuario = usuarioRepository.getReferenceById(dto.usuario().id());
            Pessoa entity = pessoaRepository.getReferenceById(id);
            PessoaUsuarioDTO.mapperDtoToEntity(dto, entity, usuario);
            entity = pessoaRepository.save(entity);
            return PessoaUsuarioDTO.fromEntity(entity);

        }  catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Transactional
    public void delete(Long id)  {
        try {
            pessoaRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
