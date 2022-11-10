package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.classes.UsuarioLoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioLoginRepository extends JpaRepository<UsuarioLoginEntity, Integer> {
    Optional<UsuarioLoginEntity> findByLoginAndSenha(String login, String senha);

    Optional<UsuarioLoginEntity> findByLogin(String login);
}
