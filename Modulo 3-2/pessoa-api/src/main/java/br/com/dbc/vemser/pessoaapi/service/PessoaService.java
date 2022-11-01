package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class PessoaService {


    private final EmailService emailService;
    private final PessoaRepository pessoaRepository;
    private final ObjectMapper objectMapper;

    public PessoaDTO create(PessoaCreateDTO pessoa) {
        PessoaEntity p = objectMapper.convertValue(pessoa, PessoaEntity.class);
        log.info("Criando pessoa...");
        PessoaEntity pessoaEntityCriada = pessoaRepository.save(p);
        emailService.sendCreateEmail(pessoaEntityCriada);
        log.info("Pessoa criada com sucesso!");
        return objectMapper.convertValue(pessoaEntityCriada, PessoaDTO.class);
    }

    public List<PessoaDTO> list() {
        return pessoaRepository.findAll().stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .toList();
    }

    public PessoaDTO update(Integer id, PessoaCreateDTO pessoaAtualizar) throws RegraDeNegocioException {
        log.info("Atualizando pessoa...");
        PessoaDTO pessoaRecuperada = list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não econtrada"));
        pessoaRecuperada.setCpf(pessoaAtualizar.getCpf());
        pessoaRecuperada.setNome(pessoaAtualizar.getNome());
        pessoaRecuperada.setDataNascimento(pessoaAtualizar.getDataNascimento());
        pessoaRecuperada.setEmail(pessoaAtualizar.getEmail());
        emailService.sendUpdateEmail(pessoaRecuperada);
        log.info("Pessoa atualizando com sucesso!");
        return objectMapper.convertValue(pessoaRecuperada, PessoaDTO.class);
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        log.info("Deletando pessoa...");
        PessoaDTO pessoaRecuperada = findById(id);
        PessoaEntity pessoaEntity = objectMapper.convertValue(pessoaRecuperada, PessoaEntity.class);
        pessoaRepository.delete(pessoaEntity);
        emailService.sendRemoveEmail(pessoaRecuperada);
        log.info("Pessoa deletada com sucesso!");
    }

//    public List<PessoaDTO> listByName(String nome) {
//        return pessoaRepository.findBy(nome).stream()
//                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
//                .toList();
//    }

    public PessoaDTO findById(Integer idPessoa) throws RegraDeNegocioException {
        return list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(idPessoa))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));
    }

}
