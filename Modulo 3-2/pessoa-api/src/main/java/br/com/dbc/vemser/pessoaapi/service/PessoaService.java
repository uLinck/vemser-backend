package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.endereco.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.dto.filme.FilmeAvaliadoDTO;
import br.com.dbc.vemser.pessoaapi.dto.lists.ListPessoaContatoDTO;
import br.com.dbc.vemser.pessoaapi.dto.lists.ListPessoaEnderecoDTO;
import br.com.dbc.vemser.pessoaapi.dto.lists.ListPessoaFilmeDTO;
import br.com.dbc.vemser.pessoaapi.dto.pessoa.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.pessoa.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.classes.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
public class PessoaService {


    private final EmailService emailService;
    private final PessoaRepository pessoaRepository;
    private final ObjectMapper objectMapper;

    public List<PessoaDTO> list() {
        return pessoaRepository.findAll().stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .toList();
    }

    public List<ListPessoaEnderecoDTO> listWithEndereco(Integer idPessoa) throws RegraDeNegocioException {
        List<ListPessoaEnderecoDTO> listaPessoasComEnderecos = new ArrayList<>();
        if (idPessoa == null) {
            listaPessoasComEnderecos.addAll(pessoaRepository.findAll().stream()
                    .map(pessoa -> {
                        ListPessoaEnderecoDTO pessoaComEnderecos = objectMapper.convertValue(pessoa, ListPessoaEnderecoDTO.class);
                        pessoaComEnderecos.setEnderecos(pessoa.getEnderecos().stream().map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class)).collect(Collectors.toList()));
                        return pessoaComEnderecos;
                    }).toList());
        }else {
            PessoaEntity pessoa = findById(idPessoa);
            ListPessoaEnderecoDTO pessoaComEnderecos = objectMapper.convertValue(pessoa, ListPessoaEnderecoDTO.class);
            pessoaComEnderecos.setEnderecos(pessoa.getEnderecos().stream().map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class)).collect(Collectors.toList()));
            listaPessoasComEnderecos.add(pessoaComEnderecos);
        }
        return listaPessoasComEnderecos;
    }

    public List<ListPessoaContatoDTO> listWithContato(Integer idPessoa) {
        if (idPessoa != null) {
            return pessoaRepository.findByIdPessoa(idPessoa).stream()
                    .map(pessoa -> objectMapper.convertValue(pessoa, ListPessoaContatoDTO.class))
                    .toList();
        }
        return pessoaRepository.findAll().stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, ListPessoaContatoDTO.class))
                .toList();
    }

    public List<ListPessoaFilmeDTO> listWithFilme(Integer idPessoa) throws RegraDeNegocioException {
        List<ListPessoaFilmeDTO> list = new ArrayList<>();
        if (idPessoa != null) {
            PessoaEntity pessoaEntity = findById(idPessoa);
            ListPessoaFilmeDTO listPessoaFilmeDTO = objectMapper.convertValue(pessoaEntity, ListPessoaFilmeDTO.class);
            listPessoaFilmeDTO.setFilmes(pessoaEntity.getFilmes().stream()
                    .map(filmes -> objectMapper.convertValue(filmes, FilmeAvaliadoDTO.class))
                    .collect(Collectors.toSet()));
            list.add(listPessoaFilmeDTO);
        } else {
            list.addAll(pessoaRepository.findAll().stream()
                    .map(pessoa -> {
                        ListPessoaFilmeDTO listPessoaFilmeDTO = objectMapper.convertValue(pessoa, ListPessoaFilmeDTO.class);
                        listPessoaFilmeDTO.setFilmes(pessoa.getFilmes().stream()
                                .map(filmes -> objectMapper.convertValue(filmes, FilmeAvaliadoDTO.class))
                                .collect(Collectors.toSet()));
                        return listPessoaFilmeDTO;
                    }).toList());
        }
        return list;
    }

    public PessoaDTO create(PessoaCreateDTO pessoa) {
        PessoaEntity p = objectMapper.convertValue(pessoa, PessoaEntity.class);
        log.info("Criando pessoa...");
        PessoaEntity pessoaEntityCriada = pessoaRepository.save(p);
        emailService.sendCreateEmail(pessoaEntityCriada);
        log.info("Pessoa criada com sucesso!");
        return objectMapper.convertValue(pessoaEntityCriada, PessoaDTO.class);
    }

    public PessoaDTO update(Integer id, PessoaCreateDTO pessoaAtualizar) throws RegraDeNegocioException {
        log.info("Atualizando pessoa...");
        PessoaEntity pessoaRecuperada = findById(id);
        pessoaRecuperada.setCpf(pessoaAtualizar.getCpf());
        pessoaRecuperada.setNome(pessoaAtualizar.getNome());
        pessoaRecuperada.setDataNascimento(pessoaAtualizar.getDataNascimento());
        pessoaRecuperada.setEmail(pessoaAtualizar.getEmail());
        pessoaRepository.save(pessoaRecuperada);
//        emailService.sendUpdateEmail(pessoaRecuperada);
        log.info("Pessoa atualizando com sucesso!");
        return objectMapper.convertValue(pessoaRecuperada, PessoaDTO.class);
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        log.info("Deletando pessoa...");
        PessoaEntity pessoaRecuperada = findById(id);
        PessoaEntity pessoaEntity = objectMapper.convertValue(pessoaRecuperada, PessoaEntity.class);
        pessoaRepository.delete(pessoaEntity);
//        emailService.sendRemoveEmail(pessoaRecuperada);
        log.info("Pessoa deletada com sucesso!");
    }

//    public List<PessoaDTO> listByName(String nome) {
//        return pessoaRepository.findBy(nome).stream()
//                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
//                .toList();
//    }

    public PessoaEntity findById(Integer id) throws RegraDeNegocioException {
        PessoaEntity pessoaEntity = pessoaRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));
        return pessoaEntity;
    }

}
