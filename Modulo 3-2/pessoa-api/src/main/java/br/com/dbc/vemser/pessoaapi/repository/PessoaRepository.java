package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.classes.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
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
}
