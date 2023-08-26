package com.fiap.techchallenge.pessoa.service;

import com.fiap.techchallenge.pessoa.domain.Usuario;
import com.fiap.techchallenge.pessoa.dto.pessoa.usuario.UsuarioDTO;
import com.fiap.techchallenge.pessoa.dto.pessoa.usuario.UsuarioPessoaDTO;
import com.fiap.techchallenge.pessoa.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }
    @Transactional(readOnly = true)
    public Page<UsuarioPessoaDTO> findAll(PageRequest pageRequest) {
        var enderecos = usuarioRepository.findAll(pageRequest);
        return enderecos.map(UsuarioPessoaDTO::fromEntity);
    }

    @Transactional(readOnly = true)
    public UsuarioPessoaDTO findById(Long id) {
        var endereco = usuarioRepository.findById(id).orElseThrow(
                () ->  new RuntimeException("Usuario não encontrado")
        );

        return UsuarioPessoaDTO.fromEntity(endereco);
    }

    @Transactional
    public UsuarioDTO save(UsuarioDTO dto) {
        var entity = UsuarioDTO.toEntity(dto);
        var enderecoSaved = usuarioRepository.save(entity);
        return UsuarioDTO.fromEntity(enderecoSaved);
    }

    @Transactional
    public UsuarioDTO update(Long id, UsuarioDTO dto) {
        try {
            Usuario entity = usuarioRepository.getReferenceById(id);
            UsuarioDTO.mapperDtoToEntity(dto, entity);
            entity = usuarioRepository.save(entity);
            return UsuarioDTO.fromEntity(entity);

        }  catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Transactional
    public void delete(Long id)  {
        try {
            usuarioRepository.deleteById(id);
        }  catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
