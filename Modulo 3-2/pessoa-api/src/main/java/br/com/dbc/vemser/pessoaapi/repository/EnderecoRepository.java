package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.classes.EnderecoEntity;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Integer> {
//    List<EnderecoEntity> findByTipoEndereco(TipoEndereco tipoEndereco);
//
//    List<EnderecoEntity> findByCepOrderByLogradouro(String cep);

    @Query(" select ep " +
            " from ENDERECO_PESSOA ep" +
            " where ep.pais like :pais")
    EnderecoEntity findByPaisJQPL(@Param("pais") String pais);

}
