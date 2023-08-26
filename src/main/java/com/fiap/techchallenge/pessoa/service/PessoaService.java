package com.fiap.techchallenge.pessoa.service;

import com.fiap.techchallenge.pessoa.domain.Pessoa;
import com.fiap.techchallenge.pessoa.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    private final Usuario usuarioRepository;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository, Usuario usuarioRepository) {
        this.pessoaRepository = pessoaRepository;
        this.usuarioRepository = usuarioRepository;
    }
    @Transactional(readOnly = true)
    public Page<PessoaEnderecoUsuarioDTO> findAll(PageRequest pageRequest) {
        var enderecos = pessoaRepository.findAll(pageRequest);
        return enderecos.map(PessoaEnderecoUsuarioDTO::fromEntity);
    }
    @Transactional(readOnly = true)
    public PessoaEnderecoUsuarioDTO findById(Long id) {
        var endereco = pessoaRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Endereço não encontrado")
        );

        return PessoaEnderecoUsuarioDTO.fromEntity(endereco);
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
