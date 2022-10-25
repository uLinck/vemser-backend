package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class ContatoService {

    private final ContatoRepository contatoRepository;

    private final PessoaRepository pessoaRepository;

    private final ObjectMapper objectMapper;


    public ContatoDTO create(Integer idPessoa, ContatoCreateDTO contato) {
        Contato p = objectMapper.convertValue(contato, Contato.class);
        log.info("Criando contato...");
        Contato contatoCriado = contatoRepository.create(idPessoa, p);
        log.info("Contato criado com sucesso!");
        return objectMapper.convertValue(contatoCriado, ContatoDTO.class);

    }

    public List<ContatoDTO> list() {
        return contatoRepository.list().stream()
                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                .toList();
    }

    public ContatoDTO update(Integer idContato, ContatoCreateDTO contatoAtualizar) throws RegraDeNegocioException {
        log.info("Atualizando contato...");
        ContatoDTO contatoRecuperado = findById(idContato);
        contatoRecuperado.setTipoContato(contatoAtualizar.getTipoContato());
        contatoRecuperado.setNumero(contatoAtualizar.getNumero());
        contatoRecuperado.setDescricao(contatoAtualizar.getDescricao());
        log.info("Contato atualizado com sucesso!");
        return objectMapper.convertValue(contatoRecuperado, ContatoDTO.class);
    }

    public void delete(Integer idContato) throws RegraDeNegocioException {
        log.info("Deletando contato...");
        ContatoDTO contatoRecuperado = findById(idContato);
        list().remove(contatoRecuperado);
        log.info("Contato Deletado com sucesso!");
    }

    public List<ContatoDTO> listByIdPessoa(Integer idPessoa) {
        return contatoRepository.listByIdPessoa(idPessoa).stream()
                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                .toList();
    }


    public boolean verifyPessoa(Integer idPessoa) throws RegraDeNegocioException {

        Pessoa pessoaRecuperada = pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(idPessoa))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));

        return pessoaRecuperada != null;

    }

    private ContatoDTO findById(Integer idContato) throws RegraDeNegocioException {
        return list().stream()
                .filter(contato -> contato.getIdContato().equals(idContato))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado"));
    }
}

