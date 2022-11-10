package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.LoginDTO;
import br.com.dbc.vemser.pessoaapi.entity.classes.UsuarioLoginEntity;
import br.com.dbc.vemser.pessoaapi.repository.UsuarioLoginRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioLoginService {
    private final ObjectMapper objectMapper;
    private final UsuarioLoginRepository usuarioLoginRepository;

    public LoginDTO create (LoginDTO loginDTO){
        UsuarioLoginEntity usuarioEntity = objectMapper.convertValue(loginDTO, UsuarioLoginEntity.class);
        usuarioEntity.setSenha(new BCryptPasswordEncoder().encode(loginDTO.getSenha()));
        usuarioLoginRepository.save(usuarioEntity);
        return loginDTO;
    }

    public Optional<UsuarioLoginEntity> findByLoginAndSenha(String login, String senha) {
        return usuarioLoginRepository.findByLoginAndSenha(login, senha);
    }

    public Optional<UsuarioLoginEntity> findById(Integer idLoginUsuario) {
        return usuarioLoginRepository.findById(idLoginUsuario);
    }

    public Optional<UsuarioLoginEntity> findByLogin(String login) {
        return usuarioLoginRepository.findByLogin(login);
    }
}
