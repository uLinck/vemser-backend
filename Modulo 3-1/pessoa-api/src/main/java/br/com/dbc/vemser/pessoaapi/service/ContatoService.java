package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {

    private ContatoRepository contatoRepository;

    private PessoaRepository pessoaRepository;

    public ContatoService(ContatoRepository contatoRepository, PessoaRepository pessoaRepository){
        this.contatoRepository = contatoRepository;
        this.pessoaRepository = pessoaRepository;
    }

    public Contato create(Integer idPessoa, Contato contato){
        return contatoRepository.create(idPessoa, contato);
    }

    public List<Contato> list(){
        return contatoRepository.list();
    }

    public Contato update(Integer idContato, Contato contatoAtualizar) throws RegraDeNegocioException {
        Contato contatoRecuperado = list().stream()
                .filter(contato -> contato.getIdContato().equals(idContato))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado"));
        contatoRecuperado.setTipoContato(contatoAtualizar.getTipoContato());
        contatoRecuperado.setNumero(contatoAtualizar.getNumero());
        contatoRecuperado.setDescricao(contatoAtualizar.getDescricao());
        return contatoRecuperado;
    }

    public void delete(Integer idContato) throws RegraDeNegocioException {
        Contato contatoRecuperado = list().stream()
                .filter(contato -> contato.getIdContato().equals(idContato))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado"));
        list().remove(contatoRecuperado);
    }

    public List<Contato> listByIdPessoa(Integer idPessoa) {
        return contatoRepository.listByIdPessoa(idPessoa);
    }


    public boolean verifyPessoa(Integer idPessoa) throws RegraDeNegocioException {

        Pessoa pessoaRecuperada = pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(idPessoa))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));

        return pessoaRecuperada != null;

    }
}
