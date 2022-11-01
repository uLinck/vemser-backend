package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
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
    private final ObjectMapper objectMapper;

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

//    public List<EnderecoDTO> listByIdPessoa(Integer idPessoa) {
//        return list().stream()
//                .filter(endereco -> endereco.getIdPessoa().equals(idPessoa))
//                .collect(Collectors.toList());
//    }


    public EnderecoDTO create(EnderecoCreateDTO endereco) {
        EnderecoEntity e = objectMapper.convertValue(endereco, EnderecoEntity.class);
        log.info("Criando endereco...");
        EnderecoEntity enderecoEntityCriado = enderecoRepository.save(e);
//        emailService.sendCreateEnderecoEmail([pessoa], enderecoEntityCriado);
        log.info("Endereco criado com sucesso!");
        return objectMapper.convertValue(enderecoEntityCriado, EnderecoDTO.class);
    }

    public EnderecoDTO update(Integer idEndereco, EnderecoCreateDTO enderecoAtualizar) throws RegraDeNegocioException {
        log.info("Atualizando endereço...");
        EnderecoEntity enderecoEntityDTO = findById(idEndereco);
        enderecoEntityDTO.setTipo(enderecoAtualizar.getTipo());
        enderecoEntityDTO.setCep(enderecoAtualizar.getCep());
        enderecoEntityDTO.setCidade(enderecoAtualizar.getCidade());
        enderecoEntityDTO.setComplemento(enderecoAtualizar.getComplemento());
        enderecoEntityDTO.setEstado(enderecoAtualizar.getEstado());
        enderecoEntityDTO.setPais(enderecoAtualizar.getPais());
        enderecoEntityDTO.setLogradouro(enderecoAtualizar.getLogradouro());
        enderecoEntityDTO.setNumero(enderecoAtualizar.getNumero());
        enderecoRepository.save(enderecoEntityDTO);
//        emailService.sendUpdateEnderecoEmail(pessoaDTO, enderecoEntityDTO);
        log.info("Endereço atualizado com sucesso!");
        return objectMapper.convertValue(enderecoEntityDTO, EnderecoDTO.class);
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


