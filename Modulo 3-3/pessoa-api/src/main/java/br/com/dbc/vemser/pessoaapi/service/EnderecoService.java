package br.com.dbc.vemser.pessoaapi.service;


import br.com.dbc.vemser.pessoaapi.dto.endereco.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.endereco.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.entity.classes.EnderecoEntity;
import br.com.dbc.vemser.pessoaapi.entity.classes.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final ObjectMapper objectMapper;
    private final PessoaService pessoaService;
    private final EmailService emailService;

    public List<EnderecoDTO> list() {
        return enderecoRepository.findAll().stream()
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

    public EnderecoDTO create(Integer idPessoa, EnderecoCreateDTO enderecoDto) throws RegraDeNegocioException {
        PessoaEntity pessoaEntity = pessoaService.findById(idPessoa);
        EnderecoEntity enderecoEntity = objectMapper.convertValue(enderecoDto, EnderecoEntity.class);

        enderecoEntity.setPessoas(Set.of(pessoaEntity));
        pessoaEntity.setEnderecos(Set.of(enderecoEntity));

        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoRepository.save(enderecoEntity), EnderecoDTO.class);
        enderecoDTO.setIdPessoa(idPessoa);
        emailService.sendCreateEnderecoEmail(pessoaEntity, enderecoEntity);
        return enderecoDTO;
    }



    public EnderecoDTO update(Integer id, EnderecoCreateDTO enderecoAtualizar) throws RegraDeNegocioException {

        EnderecoEntity enderecoEntityRecuperado = findById(id);
        PessoaEntity pessoaEntity = pessoaService.findById(enderecoAtualizar.getIdPessoa());

        enderecoEntityRecuperado.getPessoas().clear();
        enderecoEntityRecuperado.getPessoas().add(pessoaEntity);

        enderecoEntityRecuperado.setLogradouro(enderecoAtualizar.getLogradouro());
        enderecoEntityRecuperado.setNumero(enderecoAtualizar.getNumero());
        enderecoEntityRecuperado.setCep(enderecoAtualizar.getCep());
        enderecoEntityRecuperado.setCidade(enderecoAtualizar.getCidade());
        enderecoEntityRecuperado.setEstado(enderecoAtualizar.getEstado());
        enderecoEntityRecuperado.setPais(enderecoAtualizar.getPais());
        enderecoEntityRecuperado.setComplemento(enderecoAtualizar.getComplemento());
        enderecoEntityRecuperado.setTipo(enderecoAtualizar.getTipo());
        emailService.sendUpdateEnderecoEmail(pessoaEntity, enderecoEntityRecuperado);
        enderecoRepository.save(enderecoEntityRecuperado);

        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoEntityRecuperado, EnderecoDTO.class);
        return enderecoDTO;
    }

//    public boolean verifyPessoa(Integer idPessoa) throws RegraDeNegocioException {
//        PessoaEntity pessoaEntityRecuperada = pessoaRepository.findAll().stream()
//                .filter(pessoa -> pessoa.getIdPessoa().equals(idPessoa))
//                .findFirst()
//                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));
//        return pessoaEntityRecuperada != null;
//    }

    public void delete(Integer idEndereco) throws RegraDeNegocioException {
        log.info("Deletando endereço...");
        EnderecoEntity enderecoEntityDTO = findById(idEndereco);
//        PessoaDTO pessoaDTO = pessoaService.findById(enderecoEntityDTO.getIdPessoa());
        enderecoRepository.delete(enderecoEntityDTO);
//        emailService.sendRemoveEnderecoEmail(pessoaDTO, enderecoEntityDTO);
        log.info("Endereço deletado com sucesso!");
    }

    public EnderecoEntity findById(Integer idEndereco) throws RegraDeNegocioException {
        return enderecoRepository.findById(idEndereco)
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não encontrado"));
    }
}


