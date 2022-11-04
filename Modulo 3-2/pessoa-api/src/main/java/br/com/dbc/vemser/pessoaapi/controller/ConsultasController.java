package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.classes.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/consultas")
public class ConsultasController {

    private final PessoaRepository pessoaRepository;

    @GetMapping("/{findByCpf}")
    public PessoaEntity findByCPF(String cpf) {
        return pessoaRepository.findByCpf(cpf);
    }

    @GetMapping("/{findByNome}")
    public List<PessoaEntity> findByNome(String nome) {
        return pessoaRepository.findByNomeContainingIgnoreCase(nome);
    }

    @GetMapping("/{findByEmail}")
    public List<PessoaEntity> findByEmail(String email) {
        return findByEmail(email);
    }

    @GetMapping("/{findByDataNasc}")
    public List<PessoaEntity> findByDataNascimento(LocalDate inicio, LocalDate fim) {
        return pessoaRepository.findByDataNascimentoBetween(inicio, fim);
    }


}
