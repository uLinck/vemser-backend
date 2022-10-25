package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
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
    private final EmailService emailService;
    private final PessoaService pessoaService;
    private final PessoaRepository pessoaRepository;
    private final ObjectMapper objectMapper;

    public List<EnderecoDTO> list() {
        return enderecoRepository.list().stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .toList();
    }

    public EnderecoDTO listByIdEndereco(Integer id) throws RegraDeNegocioException {
        return list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Não encontrado"));
    }

    public List<EnderecoDTO> listByIdPessoa(Integer idPessoa) {
        return list().stream()
                .filter(endereco -> endereco.getIdPessoa().equals(idPessoa))
                .collect(Collectors.toList());
    }


    public EnderecoDTO create(Integer idPessoa, EnderecoCreateDTO endereco) throws RegraDeNegocioException {
        Endereco e = objectMapper.convertValue(endereco, Endereco.class);
        log.info("Criando endereco...");
        PessoaDTO a = pessoaService.findById(idPessoa);
        Endereco enderecoCriado = enderecoRepository.create(idPessoa, e);
        emailService.sendCreateEnderecoEmail(a, enderecoCriado);
        log.info("Endereco criado com sucesso!");
        return objectMapper.convertValue(enderecoCriado, EnderecoDTO.class);
    }

    public EnderecoDTO update(Integer idEndereco, EnderecoCreateDTO enderecoAtualizar) throws RegraDeNegocioException {
        log.info("Atualizando endereço...");
        Endereco enderecoDTO = enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(idEndereco))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Endereco não encontrado"));
        PessoaDTO pessoaDTO = pessoaService.findById(idEndereco);
        enderecoDTO.setTipo(enderecoAtualizar.getTipo());
        enderecoDTO.setCep(enderecoAtualizar.getCep());
        enderecoDTO.setCidade(enderecoAtualizar.getCidade());
        enderecoDTO.setComplemento(enderecoAtualizar.getComplemento());
        enderecoDTO.setEstado(enderecoAtualizar.getEstado());
        enderecoDTO.setPais(enderecoAtualizar.getPais());
        enderecoDTO.setLogradouro(enderecoAtualizar.getLogradouro());
        enderecoDTO.setNumero(enderecoAtualizar.getNumero());
        emailService.sendUpdateEnderecoEmail(pessoaDTO, enderecoDTO);
        log.info("Endereço atualizado com sucesso!");
        return objectMapper.convertValue(enderecoDTO, EnderecoDTO.class);
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
        Endereco enderecoDTO = enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(idEndereco))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não encontrado"));
        PessoaDTO pessoaDTO = pessoaService.findById(enderecoDTO.getIdPessoa());
        enderecoRepository.list().remove(enderecoDTO);
        emailService.sendRemoveEnderecoEmail(pessoaDTO, enderecoDTO);
        log.info("Endereço deletado com sucesso!");
    }
}


