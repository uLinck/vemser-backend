package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@RequiredArgsConstructor
@Slf4j
@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    private final PessoaRepository pessoaRepository;

    private final ObjectMapper objectMapper;

    public List<Endereco> list() {
        return enderecoRepository.list();
    }

    public Endereco listByIdEndereco(Integer id) throws RegraDeNegocioException {
        return enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Não encontrado"));
    }

    public List<Endereco> listByIdPessoa(Integer idPessoa) {
        return enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdPessoa().equals(idPessoa))
                .collect(Collectors.toList());
    }



    public EnderecoDTO create(Integer idPessoa, EnderecoCreateDTO endereco) {
        Endereco e = objectMapper.convertValue(endereco, Endereco.class);
        log.info("Criando contato...");
        Endereco enderecoCriado =  enderecoRepository.create(idPessoa, e);
        log.info("Contato criado com sucesso!");
        return objectMapper.convertValue(enderecoCriado, EnderecoDTO.class);
    }

    public EnderecoDTO update(Integer idEndereco, EnderecoCreateDTO enderecoAtualizar) throws RegraDeNegocioException {
        log.info("Atualizando endereço...");
        Endereco enderecoRecuperado = enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(idEndereco))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Endereco não encontrado"));
        enderecoRecuperado.setTipo(enderecoAtualizar.getTipo());
        enderecoRecuperado.setCep(enderecoAtualizar.getCep());
        enderecoRecuperado.setCidade(enderecoAtualizar.getCidade());
        enderecoRecuperado.setComplemento(enderecoAtualizar.getComplemento());
        enderecoRecuperado.setEstado(enderecoAtualizar.getEstado());
        enderecoRecuperado.setPais(enderecoAtualizar.getPais());
        enderecoRecuperado.setLogradouro(enderecoAtualizar.getLogradouro());
        enderecoRecuperado.setNumero(enderecoAtualizar.getNumero());
        log.info("Endereço atualizado com sucesso!");
        return objectMapper.convertValue(enderecoRecuperado, EnderecoDTO.class);
    }

    public boolean verifyPessoa(Integer idPessoa) throws RegraDeNegocioException {

        Pessoa pessoaRecuperada = pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(idPessoa))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));

        return pessoaRecuperada != null;

    }

    public void delete(Integer idEndereco) throws RegraDeNegocioException {
        log.info("Deletando endereço...");
        Endereco enderecoRecuperado = list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(idEndereco))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não encontrado"));
        list().remove(enderecoRecuperado);
        log.info("Endereço deletado com sucesso!");
    }
}


