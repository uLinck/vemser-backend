package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.contato.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.contato.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.entity.classes.ContatoEntity;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
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
    private final ObjectMapper objectMapper;


    public ContatoDTO create(ContatoCreateDTO contato) {
        log.info("criando contato...");
        ContatoEntity contatoEntity = objectMapper.convertValue(contato, ContatoEntity.class);
        ContatoEntity contatoCadastrado = contatoRepository.save(contatoEntity);
        log.info("Contato criado com sucesso!");
        return objectMapper.convertValue(contatoCadastrado, ContatoDTO.class);

    }

    public List<ContatoDTO> list() {
        return contatoRepository.findAll().stream()
                .map(contatoEntity -> objectMapper.convertValue(contatoEntity, ContatoDTO.class))
                .toList();
    }

    public ContatoDTO update(Integer idContato, ContatoCreateDTO contatoAtualizar) throws RegraDeNegocioException {
        log.info("Atualizando contato...");
        ContatoEntity contatoRecuperado = findById(idContato);
        contatoRecuperado.setTipoContato(contatoAtualizar.getTipoContato());
        contatoRecuperado.setNumero(contatoAtualizar.getNumero());
        contatoRecuperado.setDescricao(contatoAtualizar.getDescricao());
        contatoRepository.save(contatoRecuperado);
        log.info("Contato atualizado com sucesso!");
        return objectMapper.convertValue(contatoRecuperado, ContatoDTO.class);
    }

    public void delete(Integer idContato) throws RegraDeNegocioException {
        log.info("Deletando contato...");
        ContatoEntity contatoRecuperado = findById(idContato);
        contatoRepository.delete(contatoRecuperado);
        log.info("Contato Deletado com sucesso!");
    }

//    public List<ContatoDTO> listByIdPessoa(Integer idPessoa) {
//        List<ContatoEntity> contatoEntityRecuperado = contatoRepository.findAll().stream()
//                .filter(pessoa -> pessoa.getIdPessoa().equals(idPessoa))
//                .toList();
//        return contatoEntityRecuperado.stream()
//                .map(contato -> objectMapper.convertValue(contatoEntityRecuperado, ContatoDTO.class))
//                .collect(Collectors.toList());
//    }

    private ContatoEntity findById(Integer idContato) throws RegraDeNegocioException {
        ContatoEntity contatoEntityRecuperado = contatoRepository.findById(idContato)
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado"));
        return contatoEntityRecuperado;
    }
}

