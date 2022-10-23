package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Slf4j
@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    private final ObjectMapper objectMapper;
    public PessoaDTO create(PessoaCreateDTO pessoa) {
        Pessoa p = objectMapper.convertValue(pessoa, Pessoa.class);
        log.info("Criando pessoa...");
        Pessoa pessoaCriada = pessoaRepository.create(p);
        log.info("Pessoa criada com sucesso!");
        return objectMapper.convertValue(pessoaCriada, PessoaDTO.class);
    }

    public List<Pessoa> list(){
        return pessoaRepository.list();
    }

    public PessoaDTO update(Integer id, PessoaCreateDTO pessoaAtualizar) throws RegraDeNegocioException {
        log.info("Atualizando pessoa...");
        Pessoa pessoaRecuperada = list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não econtrada"));
        pessoaRecuperada.setCpf(pessoaAtualizar.getCpf());
        pessoaRecuperada.setNome(pessoaAtualizar.getNome());
        pessoaRecuperada.setDataNascimento(pessoaAtualizar.getDataNascimento());
        log.info("Pessoa atualizando com sucesso!");
        return objectMapper.convertValue(pessoaRecuperada, PessoaDTO.class);
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        log.info("Deletando pessoa...");
        Pessoa pessoaRecuperada = list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não econtrada"));
        list().remove(pessoaRecuperada);
        log.info("Pessoa deletada com sucesso!");
    }

    public List<Pessoa> listByName(String nome) {
        return pessoaRepository.listByName(nome);
    }
}
