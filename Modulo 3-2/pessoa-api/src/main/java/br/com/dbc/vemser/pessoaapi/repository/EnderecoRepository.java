package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Integer> {
    List<EnderecoEntity> findByTipoEndereco(Integer tipoEndereco);

    List<EnderecoEntity> findByCepOrderByLogradouro(String cep);
}
