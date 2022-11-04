package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.classes.PessoaEntity;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {
    PessoaEntity findByCpf(String cpf);
    List<PessoaEntity> findByNomeContainingIgnoreCase(String nome);
    List<PessoaEntity> findByEmailContaining(String Email);
    List<PessoaEntity> findByDataNascimentoBetween(LocalDate inicio, LocalDate fim);
    List<PessoaEntity> findByIdPessoa(Integer id);

    @Query("      select p " +
            "       from pessoa p " +
            "      where p.nome = :nome" +
            "        and p.dataNascimento = :dtNascimento")
    PessoaEntity findPessoaEntitiesByNome(@Param("nome") String nome,
                                          @Param("dataNascimento") LocalDate dtNascimento);

    @Query("      select p " +
            "       from pessoa p " +
            "      where p.nome like :nome")
    List<PessoaEntity> findByNomeJQPL(@Param("nome") String nome);

    // pessoa que possuem contato

    @Query("  select p" +
            "   from pessoa p " +
            "   join p.contatos c")
    List<PessoaEntity> recuperarPessoasQueTemContratoComercial();
}
